package com.example.darte.cleanarchitectureexample.data

import com.google.firebase.auth.FirebaseAuth
import java.lang.NullPointerException

class UserIdInFireBase {
    companion object {
        fun getUid():String{
            val user = FirebaseAuth.getInstance().currentUser
            return user!!.uid
        }
    }
}