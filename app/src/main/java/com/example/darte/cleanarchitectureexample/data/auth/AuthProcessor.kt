package com.example.darte.cleanarchitectureexample.data.auth

import io.reactivex.Single

interface AuthProcessor {

    fun currentUserIsLoggedIn():Single<Boolean>

    fun signUpUserAsync(email:String,password:String):Single<Boolean>
}