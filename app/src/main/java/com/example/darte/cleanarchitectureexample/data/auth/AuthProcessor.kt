package com.example.darte.cleanarchitectureexample.data.auth

interface AuthProcessor {

    fun currentUserIsLoggedIn():Boolean
}