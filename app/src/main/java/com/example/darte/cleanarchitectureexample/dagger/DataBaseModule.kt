package com.example.darte.cleanarchitectureexample.dagger

import com.example.darte.cleanarchitectureexample.data.database.DataBase
import com.example.darte.cleanarchitectureexample.domain.models.PersonalData
import com.example.darte.cleanarchitectureexample.domain.usecases.registration.PersonalDataSubmissionToDbUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase() = DataBase()

    @Provides
    @Singleton
    fun providePersonalDataSubmissionToDbUseCase(database:DataBase,personalData:PersonalData):PersonalDataSubmissionToDbUseCase
            = PersonalDataSubmissionToDbUseCase(database,personalData)
}