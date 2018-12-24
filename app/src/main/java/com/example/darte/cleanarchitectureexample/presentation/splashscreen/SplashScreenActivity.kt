package com.example.darte.cleanarchitectureexample.presentation.splashscreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.darte.cleanarchitectureexample.ECDApplication
import com.example.darte.cleanarchitectureexample.R
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class SplashScreenActivity : AppCompatActivity(),SplashView {

    @Inject lateinit var mSplashScreenPresenter:SplashScreenPresenter
    private val navigator:Navigator = SupportAppNavigator(this,-1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        (application as ECDApplication).ecdComponent.inject(this)
    }

    override fun onResume() {
        super.onResume()
        mSplashScreenPresenter.subscribe(this)
        mSplashScreenPresenter.setNavigator(navigator)
        mSplashScreenPresenter.onAuthButtonWasClicked()

    }

    override fun onPause() {
        super.onPause()
        mSplashScreenPresenter.unsubscribe()
        mSplashScreenPresenter.removeNavigator()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        mSplashScreenPresenter.onBackPressed()
    }
}
