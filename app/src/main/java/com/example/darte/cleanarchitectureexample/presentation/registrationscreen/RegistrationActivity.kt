package com.example.darte.cleanarchitectureexample.presentation.registrationscreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.darte.cleanarchitectureexample.ECDApplication
import com.example.darte.cleanarchitectureexample.R
import com.redmadrobot.inputmask.MaskedTextChangedListener
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import kotlinx.android.synthetic.main.activity_registration.*
import javax.inject.Inject

class RegistrationActivity:AppCompatActivity(), RegistrationView{

    @Inject lateinit var mRegistrationPresenter: RegistrationPresenter
    private val navigator: Navigator = SupportAppNavigator(this,-1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        (application as ECDApplication).ecdComponent.inject(this)

        initializeInputMaskForPhoneNumber(phoneUserNumber)

        buttonGetSignedUp.setOnClickListener {
            onSignUpButtonClicked()
        }
    }

    override fun onResume() {
        super.onResume()
        mRegistrationPresenter.subscribe(this)
        mRegistrationPresenter.setNavigator(navigator)
    }

    override fun onStop() {
        super.onStop()
        mRegistrationPresenter.unsubscribe()
        mRegistrationPresenter.removeNavigator()
    }

    override fun showToast(resId:Int){
        Toast.makeText(this,
            resId,
            Toast.LENGTH_SHORT).show()
    }

    private fun onSignUpButtonClicked() {
        when {
                !mRegistrationPresenter.emailIsChecked(emailOfUser) -> return
                !mRegistrationPresenter.passwordIsChecked(passwordOfUser,secondPasswordOfUser) -> return
                !mRegistrationPresenter.lastNameIsChecked(surnameOfUser) -> return
                !mRegistrationPresenter.userFirstNameIsChecked(nameOfUser) -> return
                !mRegistrationPresenter.middleNameIsChecked(patronymicOfUser) -> return
                !mRegistrationPresenter.phoneNumberIsChecked(phoneUserNumber) -> return

            else -> {
                mRegistrationPresenter.signUpAsync()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        mRegistrationPresenter.navigateBack()
    }

    private fun initializeInputMaskForPhoneNumber(phoneNumber: EditText){
        val listener = MaskedTextChangedListener("+7([000]) [000]-[00]-[00]",phoneNumber)
        phoneNumber.addTextChangedListener(listener)
        phoneNumber.onFocusChangeListener = listener
    }
}
