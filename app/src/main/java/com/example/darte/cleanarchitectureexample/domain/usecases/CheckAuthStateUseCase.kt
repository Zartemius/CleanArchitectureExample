package com.example.darte.cleanarchitectureexample.domain.usecases

import com.example.darte.cleanarchitectureexample.data.auth.AuthProcessor
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class CheckAuthStateUseCase @Inject constructor(private val authProcessor: AuthProcessor) {



    fun userIsLoggedIn():Single<Boolean> {
        val authenticationResult = authProcessor.currentUserIsLoggedIn()
        return authenticationResult.observeOn(AndroidSchedulers.mainThread())
    }
}