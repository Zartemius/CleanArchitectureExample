package com.example.darte.cleanarchitectureexample.presentation.splashscreen

import com.example.darte.cleanarchitectureexample.router.Screens
import com.example.darte.cleanarchitectureexample.router.SmartRouter
import ru.terrakok.cicerone.Router

class SplashScreenRouter(private val mRouter: Router):SmartRouter{

    override fun navigateBack() {
        mRouter.finishChain()
    }

    override fun navigateForward() {
        mRouter.navigateTo(Screens.Companion.MainScreen())
    }
}