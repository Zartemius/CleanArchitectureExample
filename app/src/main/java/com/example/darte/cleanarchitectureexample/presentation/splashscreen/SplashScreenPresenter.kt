package com.example.darte.cleanarchitectureexample.presentation.splashscreen

import android.util.Log
import android.widget.EditText
import com.example.darte.cleanarchitectureexample.domain.usecases.CheckAuthStateUseCase
import com.example.darte.cleanarchitectureexample.router.SplashScreenRouter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

class SplashScreenPresenter @Inject constructor(private val mCheckAuthStateUseCase:CheckAuthStateUseCase,
                            private val mSplashScreenRouter: SplashScreenRouter) {

    private var mSplashScreenView:SplashView? = null
    lateinit var disposable: Disposable

    fun subscribe(splashView: SplashView){
        mSplashScreenView = splashView
    }

    fun onAuthButtonWasClicked(){
        Log.i("SPLASH_TEST", "border_one")
        //mSplashScreenRouter.navigateForward()
        val userWasLoggedIn = mCheckAuthStateUseCase.userIsLoggedIn()
        disposable = userWasLoggedIn.observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                result -> Log.i("AUTH_RESULT", "result" + result)
            }

    }

    fun unsubscribe(){
        disposable.dispose()
        mSplashScreenView = null
    }

    fun onBackPressed(){
        mSplashScreenRouter.navigateBack()
    }

    fun setNavigator(navigator: Navigator){
        mSplashScreenRouter.setNavigator(navigator)
    }

    fun removeNavigator(){
        mSplashScreenRouter.removeNavigator()
    }
}