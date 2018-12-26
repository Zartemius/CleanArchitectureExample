package com.example.darte.cleanarchitectureexample.data.database

import com.example.darte.cleanarchitectureexample.data.FireStoreDataBase
import com.example.darte.cleanarchitectureexample.data.UserIdInFireBase
import com.example.darte.cleanarchitectureexample.domain.models.AuthData
import com.example.darte.cleanarchitectureexample.domain.models.PersonalData
import io.reactivex.Single

class DataBase:DataBaseRepository {

    override fun submitUserPersonalData(personalData:PersonalData):Single<Boolean>{
        val fireStoreDataBase = FireStoreDataBase.getInstance()
        val uid = UserIdInFireBase.getUid()
        return Single.create { emitter ->
            fireStoreDataBase.collection("users")
                .document(uid)
                .set(personalData)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        emitter.onSuccess(true)
                    }else{
                        emitter.onSuccess(false)
                    }
                }
        }
    }
}