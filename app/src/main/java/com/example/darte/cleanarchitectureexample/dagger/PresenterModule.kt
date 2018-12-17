package com.example.darte.cleanarchitectureexample.dagger

import com.example.darte.cleanarchitectureexample.domain.usecases.GetLiveOrderDataUseCase
import com.example.darte.cleanarchitectureexample.presentation.MainScreenPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun providePresenter(useCaseGetLive:GetLiveOrderDataUseCase):MainScreenPresenter = MainScreenPresenter(useCaseGetLive)
}