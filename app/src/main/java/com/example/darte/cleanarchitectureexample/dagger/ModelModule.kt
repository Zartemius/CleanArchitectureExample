package com.example.darte.cleanarchitectureexample.dagger

import com.example.darte.cleanarchitectureexample.domain.models.AuthData
import com.example.darte.cleanarchitectureexample.domain.models.PersonalData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModelModule {

    @Provides
    @Singleton
    fun providePersonalData():PersonalData = PersonalData()

    @Provides
    @Singleton
    fun provideAuthData():AuthData = AuthData()
}