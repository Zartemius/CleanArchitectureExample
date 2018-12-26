package com.example.darte.cleanarchitectureexample.dagger

import com.example.darte.cleanarchitectureexample.data.database.LiveDataBase
import com.example.darte.cleanarchitectureexample.domain.usecases.order.GettingOrderLiveDataUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LiveDataBaseModule {

    @Provides
    @Singleton
    fun provideLiveDataBase(): LiveDataBase =
        LiveDataBase()

    @Provides
    @Singleton
    fun provideOrderDataUseCase(liveDataBase: LiveDataBase): GettingOrderLiveDataUseCase
            = GettingOrderLiveDataUseCase(liveDataBase)
}