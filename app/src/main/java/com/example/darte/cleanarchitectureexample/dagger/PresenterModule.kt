package com.example.darte.cleanarchitectureexample.dagger

import com.example.darte.cleanarchitectureexample.domain.usecases.authentication.CheckAuthStateUseCase
import com.example.darte.cleanarchitectureexample.domain.usecases.order.GettingOrderLiveDataUseCase
import com.example.darte.cleanarchitectureexample.domain.usecases.registration.PersonalDataSubmissionToDbUseCase
import com.example.darte.cleanarchitectureexample.domain.usecases.registration.UserRegistrationUseCase
import com.example.darte.cleanarchitectureexample.presentation.mainscreen.MainScreenPresenter
import com.example.darte.cleanarchitectureexample.presentation.registrationscreen.RegistrationPresenter
import com.example.darte.cleanarchitectureexample.presentation.splashscreen.SplashScreenPresenter
import com.example.darte.cleanarchitectureexample.router.RegistrationRouter
import com.example.darte.cleanarchitectureexample.router.SplashScreenRouter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun providePresenter(useCaseGettingLive: GettingOrderLiveDataUseCase): MainScreenPresenter =
        MainScreenPresenter(useCaseGettingLive)

    @Provides
    @Singleton
    fun provideSplashScreenPresenter(checkAuthStateUseCase: CheckAuthStateUseCase, router: SplashScreenRouter):SplashScreenPresenter =
        SplashScreenPresenter(checkAuthStateUseCase,router)

    @Provides
    @Singleton
    fun provideRegistrationPresenter(userRegistrationUseCase: UserRegistrationUseCase, personalDataSubmissionToDbUseCase:PersonalDataSubmissionToDbUseCase,
                                     router:RegistrationRouter):RegistrationPresenter =
        RegistrationPresenter(userRegistrationUseCase,personalDataSubmissionToDbUseCase,router)
}