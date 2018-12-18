package com.example.darte.cleanarchitectureexample.presentation.splashscreen

import com.example.darte.cleanarchitectureexample.domain.usecases.CheckAuthStateUseCase
import javax.inject.Inject

class SplashScreenPresenter @Inject constructor(private val mCheckAuthStateUseCase:CheckAuthStateUseCase,
                            private val mSplashScreenRouter: SplashScreenRouter) {

    private var mSplashScreenView:SplashView? = null

    fun onViewCreated(splashView: SplashView){
        mSplashScreenView = splashView
    }

    fun onAuthButtonWasClicked(){
        mSplashScreenRouter.navigateForward()
    }


    fun onDestroy(){
        mSplashScreenView = null
    }
}