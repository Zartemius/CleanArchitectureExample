package com.example.darte.cleanarchitectureexample.domain.usecases

import com.example.darte.cleanarchitectureexample.data.auth.AuthProcessor
import javax.inject.Inject

class CheckAuthStateUseCase @Inject constructor(private val authProcessor: AuthProcessor) {

    fun userIsLoggedIn():Boolean{
        return authProcessor.currentUserIsLoggedIn()
    }
}