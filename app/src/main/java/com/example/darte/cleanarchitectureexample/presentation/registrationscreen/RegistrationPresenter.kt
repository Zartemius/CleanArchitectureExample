package com.example.darte.cleanarchitectureexample.presentation.registrationscreen

import android.text.TextUtils
import android.widget.EditText
import com.example.darte.cleanarchitectureexample.R
import com.example.darte.cleanarchitectureexample.domain.usecases.registration.PersonalDataSubmissionToDbUseCase
import com.example.darte.cleanarchitectureexample.domain.usecases.registration.UserRegistrationUseCase
import com.example.darte.cleanarchitectureexample.router.RegistrationRouter
import com.redmadrobot.inputmask.MaskedTextChangedListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

class RegistrationPresenter @Inject constructor(private val mUserRegistrationUseCase: UserRegistrationUseCase,
                                                private val mPersonalDataSubmissionUseCase: PersonalDataSubmissionToDbUseCase,
                                                private val mRegistrationRouter: RegistrationRouter) {

    private var mRegistrationView:RegistrationView? = null
    private lateinit var disposable: Disposable

    fun subscribe(registrationView: RegistrationView){
        mRegistrationView = registrationView
    }

    fun unsubscribe(){
        if(disposable.isDisposed) {
            disposable.dispose()
        }
        mRegistrationView = null
    }

    fun setNavigator(navigator: Navigator){
        mRegistrationRouter.setNavigator(navigator)
    }

    fun removeNavigator(){
        mRegistrationRouter.removeNavigator()
    }

    fun navigateBack(){
        mRegistrationRouter.navigateBack()
    }

    private fun navigateForward(){
        mRegistrationRouter.navigateForward()
    }

    private fun getDataInStringFormat(data:EditText):String{
        val userData = data.text.toString().trim{it <= ' '}
        return userData
    }

    fun userFirstNameIsChecked(firstName:EditText):Boolean{
        val userFirstName = getDataInStringFormat(firstName)

        if(TextUtils.isEmpty(userFirstName)){
            mRegistrationView!!.showToast(R.string.enter_name)
            return false
        }else if(!userFirstName.matches("""[а-яА-Я]+""".toRegex())){
            mRegistrationView!!.showToast(R.string.wrong_name_data_format)
            return false
        }
        mPersonalDataSubmissionUseCase.setFirstName(userFirstName)
        return true
    }

    fun lastNameIsChecked(lastName:EditText):Boolean{
        val userLastName = getDataInStringFormat(lastName)

        if(TextUtils.isEmpty(userLastName)){
            mRegistrationView!!.showToast(R.string.enter_surname)
            return false
        }else if(!userLastName.matches("""[а-яА-Я\-]+""".toRegex())){
            mRegistrationView!!.showToast(R.string.wrong_surname_data_format)
            return false
        }
        mPersonalDataSubmissionUseCase.setLastName(userLastName)
        return true
    }

    fun middleNameIsChecked(middleName:EditText):Boolean{
        val userMiddleName = getDataInStringFormat(middleName)
        if(TextUtils.isEmpty(userMiddleName)){
            mRegistrationView!!.showToast(R.string.enter_patronymic)
            return false
        }else if(!userMiddleName.matches("""[а-яА-Я]+""".toRegex())){
            mRegistrationView!!.showToast(R.string.wrong_middle_name_data_format)
            return false

        }
        mPersonalDataSubmissionUseCase.setMiddleMan(userMiddleName)
        return true
    }

    fun phoneNumberIsChecked(phoneNumber:EditText):Boolean{
        val userPhoneNumber = getDataInStringFormat(phoneNumber)

        if(TextUtils.isEmpty(userPhoneNumber)){
            mRegistrationView!!.showToast(R.string.enter_phone_number)
            return false
        }
        mPersonalDataSubmissionUseCase.setPhoneNumber(userPhoneNumber)
        return true
    }

    fun emailIsChecked(email:EditText):Boolean{
        val userEmail = getDataInStringFormat(email)

        if(TextUtils.isEmpty(userEmail)){
            mRegistrationView!!.showToast(R.string.enter_email)
            return false
        }else if(!userEmail.matches("""[a-zA-Z_0-9.\-]+@[a-zA-Z]+\.[a-zA-Z]+""".toRegex())){
            mRegistrationView!!.showToast(R.string.wrong_email_data_format)
            return false
        }
        mUserRegistrationUseCase.setEmail(userEmail)
        mPersonalDataSubmissionUseCase.setEmail(userEmail)
        return true
    }

    fun passwordIsChecked(password:EditText, secondPassword:EditText):Boolean{
        val userPassword = getDataInStringFormat(password)
        val userSecondPassword = getDataInStringFormat(secondPassword)

        if(TextUtils.isEmpty(userPassword)){
            mRegistrationView!!.showToast(R.string.enter_password)
            return false
        }else if(TextUtils.isEmpty(userSecondPassword)){
            mRegistrationView!!.showToast(R.string.confirm_password)
            return false
        }else if(userPassword.length < 6){
            mRegistrationView!!.showToast(R.string.password_is_too_short)
            return false
        }else if(!userPassword.equals(userSecondPassword)){
            mRegistrationView!!.showToast(R.string.passwords_do_not_match)
            return false
        }

        mUserRegistrationUseCase.setPassword(userPassword)
        return true
    }

    fun signUpAsync(){
        val allDataIsPrepared = mUserRegistrationUseCase.allRequiredDataIsPrepared()
        if(allDataIsPrepared){
            val userWasSignedUp = mUserRegistrationUseCase.signUpUserAsync()
            disposable = userWasSignedUp.observeOn(AndroidSchedulers.mainThread())
                .subscribe{ resultIsPositive ->
                    if(resultIsPositive) {
                        submitUserPersonalDataToDbAsync()
                    }else{
                        mRegistrationView!!.showToast(R.string.error_of_registration)
                    }
                }
        }
    }

    private fun submitUserPersonalDataToDbAsync(){
        val allDataIsPrepared = mPersonalDataSubmissionUseCase.allRequiredDataIsPrepared()
        if(allDataIsPrepared) {
            val dataWasSubmitted = mPersonalDataSubmissionUseCase.submitDataAsync()
            disposable = dataWasSubmitted.observeOn(AndroidSchedulers.mainThread())
                .subscribe { resultIsPositive ->
                    if (resultIsPositive) {
                        navigateForward()
                    } else {
                        mRegistrationView!!.showToast(R.string.repeat_attempt)
                    }
                }
        }
    }
}