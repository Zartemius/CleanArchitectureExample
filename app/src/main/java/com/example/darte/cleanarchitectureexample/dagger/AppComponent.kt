package com.example.darte.cleanarchitectureexample.dagger

import com.example.darte.cleanarchitectureexample.presentation.mainscreen.MainScreenActivity
import com.example.darte.cleanarchitectureexample.presentation.registrationscreen.RegistrationActivity
import com.example.darte.cleanarchitectureexample.presentation.splashscreen.SplashScreenActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
                      PresenterModule::class,
                      LiveDataBaseModule::class,
                      NavigationModule::class,
                      AuthProcessingModule::class,
                      DataBaseModule::class,
                      ModelModule::class])

interface AppComponent {
    fun inject(target: MainScreenActivity)
    fun inject(target: SplashScreenActivity)
    fun inject(target: RegistrationActivity)
}