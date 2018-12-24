package com.example.darte.cleanarchitectureexample.presentation.signup

import android.text.TextUtils
import android.widget.EditText
import com.example.darte.cleanarchitectureexample.domain.usecases.SignUpUserUseCase
import com.example.darte.cleanarchitectureexample.router.SigningUpRouter
import io.reactivex.disposables.Disposable
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

class SigningUpPresenter @Inject constructor(private val mSignUpUserUseCase: SignUpUserUseCase,
                                             private val mSigningUpRouter: SigningUpRouter) {

    var mSigningUpView:SigningUpView? = null
    lateinit var disposable: Disposable
    var userDataIsCorrect:Boolean = true


    fun subscribe(signingUpView: SigningUpView){
        mSigningUpView = signingUpView
    }

    fun unsubscribe(){
        disposable.dispose()
        mSigningUpView = null
    }

    fun setNavigator(navigator: Navigator){
        mSigningUpRouter.setNavigator(navigator)
    }

    fun removeNavigator(){
        mSigningUpRouter.removeNavigator()
    }

    fun onBackPressed(){
        mSigningUpRouter.navigateBack()
    }

    fun navigateForward(){
        mSigningUpRouter.navigateForward()
    }

    fun getDataInStringFormat(data:EditText):String{
        val userData = data.text.toString().trim{it <= ' '}
        return userData
    }

    fun checkUserName(userName:String){
        if(TextUtils.isEmpty(userName)){
            //showToast
            setFlagFalse()
        }else if(userName.matches("""[а-яА-Я]+""".toRegex())){
            //showToast
            setFlagFalse()
        }
        mSignUpUserUseCase.setName(userName)
    }

    fun checkEmail(userEmail:String){
        if(TextUtils.isEmpty(userEmail)){
            //showToast
            setFlagFalse()
        }else if(userEmail.matches("""[а-яА-Я\-]+""".toRegex())){
            //showToast
            setFlagFalse()
        }

        mSignUpUserUseCase.setEmail(userEmail)
    }

    fun setFlagFalse(){
        userDataIsCorrect = false
    }
}