package com.example.darte.cleanarchitectureexample.domain.usecases

import com.example.darte.cleanarchitectureexample.data.auth.AuthProcessor
import com.example.darte.cleanarchitectureexample.domain.models.AuthData

import javax.inject.Inject

class SignUpUserUseCase @Inject constructor(private val authProcessor: AuthProcessor) {

    val userAuthData: AuthData = AuthData()

    fun setName(userName:String){
        userAuthData.userName = userName
    }

    fun setEmail(userEmail:String){
        userAuthData.userEmail = userEmail
    }

   /* fun getSignedUpAsync(user:String, email:String):Boolean{
        authProcessor.signUpUserAsync(user,email)
    }*/

    fun dataIsPreparedForSubmission():Boolean{
        if(userAuthData.userName == null){
            return false
        }else if(userAuthData.userEmail == null){
            return false
        }
        return true
    }

}