package com.example.darte.cleanarchitectureexample.domain.usecases.registration

import com.example.darte.cleanarchitectureexample.data.auth.AuthProcessor
import com.example.darte.cleanarchitectureexample.domain.models.AuthData
import io.reactivex.Single

import javax.inject.Inject

class UserRegistrationUseCase @Inject constructor(private val mAuthProcessor:AuthProcessor,
                                                  private val mUserAuthData:AuthData){

    fun setEmail(email:String){
        mUserAuthData.userEmail = email
    }

    fun setPassword(password:String){
        mUserAuthData.userPassword = password
    }

  fun allRequiredDataIsPrepared():Boolean{
        if(mUserAuthData.userEmail == null){
            return false
        }else if(mUserAuthData.userPassword == null){
            return false
        }
        return true
    }

    fun signUpUserAsync():Single<Boolean>{
        val userEmail = mUserAuthData.userEmail
        val userPassword =  mUserAuthData.userPassword
        return mAuthProcessor.signUpUserAsync(userEmail!!,userPassword!!)
    }
}