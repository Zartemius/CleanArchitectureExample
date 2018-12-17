package com.example.darte.cleanarchitectureexample.dagger

import com.example.darte.cleanarchitectureexample.presentation.MainScreen
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, PresenterModule::class,LiveDataBaseModule::class])
interface AppComponent {
    fun inject(target:MainScreen)
}