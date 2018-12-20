package com.example.darte.cleanarchitectureexample.presentation.splashscreen

import android.util.Log
import com.example.darte.cleanarchitectureexample.router.Screens
import com.example.darte.cleanarchitectureexample.router.SmartRouter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SplashScreenRouter @Inject constructor(private val mRouter:Router):SmartRouter{

    override fun navigateBack() {
        mRouter.finishChain()
    }

    override fun navigateForward() {
        mRouter.navigateTo(Screens.Companion.MainScreen())

        Log.i("SPLASH_TEST", "border_two "+ mRouter.hashCode())


    }
}