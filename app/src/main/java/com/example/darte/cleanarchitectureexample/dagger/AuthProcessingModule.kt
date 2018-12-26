package com.example.darte.cleanarchitectureexample.dagger

import com.example.darte.cleanarchitectureexample.data.auth.AuthProcessorImpl
import com.example.darte.cleanarchitectureexample.domain.models.AuthData
import com.example.darte.cleanarchitectureexample.domain.usecases.authentication.CheckAuthStateUseCase
import com.example.darte.cleanarchitectureexample.domain.usecases.registration.UserRegistrationUseCase
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
    fun provideCheckAuthStatusUseCase(authProcessorImpl:AuthProcessorImpl) =
        CheckAuthStateUseCase(
            authProcessorImpl
        )

    @Provides
    @Singleton
    fun provideUserRegistrationUseCase(authProcessorImpl:AuthProcessorImpl, authData:AuthData) =
        UserRegistrationUseCase(authProcessorImpl,authData)

}