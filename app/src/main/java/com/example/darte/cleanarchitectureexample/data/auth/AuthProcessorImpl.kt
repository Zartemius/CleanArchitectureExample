package com.example.darte.cleanarchitectureexample.data.auth

import com.google.firebase.auth.FirebaseAuth

class AuthProcessorImpl:AuthProcessor{

    private val mFireBaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun currentUserIsLoggedIn():Boolean{
        val resultOfCheck = mFireBaseAuth.currentUser != null
        return resultOfCheck
    }
}