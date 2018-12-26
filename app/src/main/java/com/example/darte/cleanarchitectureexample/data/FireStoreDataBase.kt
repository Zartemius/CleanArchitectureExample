package com.example.darte.cleanarchitectureexample.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

class FireStoreDataBase {
    companion object {
        fun getInstance():FirebaseFirestore{
            val fireStoreDataBase = FirebaseFirestore.getInstance()
            val settings = FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build()
            fireStoreDataBase.firestoreSettings = settings
            return fireStoreDataBase
        }
    }
}