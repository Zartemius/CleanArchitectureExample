package com.example.darte.cleanarchitectureexample.dagger

import com.example.darte.cleanarchitectureexample.presentation.mainscreen.MainScreenActivity
import com.example.darte.cleanarchitectureexample.presentation.splashscreen.SplashScreenActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, PresenterModule::class,LiveDataBaseModule::class,NavigationModule::class,AuthProcessingModule::class])
interface AppComponent {

    fun inject(target: MainScreenActivity)
    fun inject(target: SplashScreenActivity)
}