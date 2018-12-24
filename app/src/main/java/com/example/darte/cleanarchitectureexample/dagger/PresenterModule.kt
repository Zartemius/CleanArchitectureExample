package com.example.darte.cleanarchitectureexample.dagger

import com.example.darte.cleanarchitectureexample.domain.usecases.CheckAuthStateUseCase
import com.example.darte.cleanarchitectureexample.domain.usecases.GetLiveOrderDataUseCase
import com.example.darte.cleanarchitectureexample.presentation.mainscreen.MainScreenPresenter
import com.example.darte.cleanarchitectureexample.presentation.splashscreen.SplashScreenPresenter
import com.example.darte.cleanarchitectureexample.router.SplashScreenRouter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun providePresenter(useCaseGetLive:GetLiveOrderDataUseCase): MainScreenPresenter =
        MainScreenPresenter(useCaseGetLive)

    @Provides
    @Singleton
    fun provideSplashScreenPresenter(checkAuthStateUseCase:CheckAuthStateUseCase,router: SplashScreenRouter):SplashScreenPresenter =
        SplashScreenPresenter(checkAuthStateUseCase,router)
}