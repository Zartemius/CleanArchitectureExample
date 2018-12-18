package com.example.darte.cleanarchitectureexample.dagger

import com.example.darte.cleanarchitectureexample.presentation.splashscreen.SplashScreenRouter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class NavigationModule {

    private val cicerone:Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideRouter() = cicerone.router

    @Provides
    @Singleton
    fun provideNavigationHolder() = cicerone.navigatorHolder

    @Provides
    @Singleton
    fun provideSplashScreenRouter(router:Router) = SplashScreenRouter(router)
}