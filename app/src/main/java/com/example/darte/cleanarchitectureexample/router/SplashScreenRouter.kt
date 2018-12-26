package com.example.darte.cleanarchitectureexample.router

import android.util.Log
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SplashScreenRouter @Inject constructor(private val mRouter:Router,
                                             private val mNavigatorHolder: NavigatorHolder):SmartRouter{

    override fun navigateBack() {
        mRouter.exit()
    }

    override fun navigateForward() {
        mRouter.navigateTo(Screens.Companion.SigningUpScreen())
    }

    override fun setNavigator(navigator:Navigator) {
       mNavigatorHolder.setNavigator(navigator)
    }

    override fun removeNavigator() {
       mNavigatorHolder.removeNavigator()

    }
}