package com.example.darte.cleanarchitectureexample.dagger

import com.example.darte.cleanarchitectureexample.data.auth.AuthProcessorImpl
import com.example.darte.cleanarchitectureexample.domain.usecases.CheckAuthStateUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AuthProcessingModule{

    @Provides
    @Singleton
    fun provideAuthProcessImpl():AuthProcessorImpl = AuthProcessorImpl()

    @Provides
    @Singleton
    fun provideCheckAuthStatusUseCase(authProcessorImpl:AuthProcessorImpl) = CheckAuthStateUseCase(authProcessorImpl)

}