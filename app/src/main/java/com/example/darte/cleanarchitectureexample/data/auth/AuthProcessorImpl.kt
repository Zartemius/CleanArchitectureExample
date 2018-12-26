package com.example.darte.cleanarchitectureexample.data.auth

import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Single
import java.lang.Exception

class AuthProcessorImpl:AuthProcessor{

    override fun currentUserIsLoggedIn(): Single<Boolean> {
        return Single.create { emitter ->
            try {
                val fireBaseAuthInstance = getFireBaseAuthInstance()
                val resultOfCheck = fireBaseAuthInstance.currentUser != null
                emitter.onSuccess(resultOfCheck)
            }catch(e:Exception){
                e.printStackTrace()
            }
        }
    }

    override fun signUpUserAsync(email:String,password:String): Single<Boolean> {
        return Single.create { emitter->
            val fireBaseAuthInstance = getFireBaseAuthInstance()
            fireBaseAuthInstance.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener{ task ->
                    if (!task.isSuccessful) {
                        emitter.onSuccess(false)
                    } else {
                        emitter.onSuccess(true)
                        //addDataToFireBaseDataBase(email,name,surname,patronymic,phoneNumber)
                    }
                }
        }
    }

    override fun logInUserAsync(email: String, password: String):Single<Boolean> {
        return Single.create { emitter ->
            val fireBaseAuthInstance = getFireBaseAuthInstance()
            fireBaseAuthInstance.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener { task->
                    if(task.isSuccessful){
                        emitter.onSuccess(true)
                    }else{
                        emitter.onSuccess(false)
                    }
                }
        }
    }

    private fun getFireBaseAuthInstance():FirebaseAuth{
        return FirebaseAuth.getInstance()
    }
}