package com.example.darte.cleanarchitectureexample.dagger

import com.example.darte.cleanarchitectureexample.data.livedatabase.LiveDataBase
import com.example.darte.cleanarchitectureexample.domain.usecases.GetLiveOrderDataUseCase
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
    fun provideOrderDataUseCase(liveDataBase: LiveDataBase):GetLiveOrderDataUseCase
            = GetLiveOrderDataUseCase(liveDataBase)
}