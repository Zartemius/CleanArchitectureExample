package com.example.darte.cleanarchitectureexample.data

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.darte.cleanarchitectureexample.R
import com.example.darte.cleanarchitectureexample.domain.models.Order
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.*

class DatabaseListener:DataBase {

    private val ordersCollection: CollectionReference = getInstanceOfFireStoreDb()
        .collection("orders")

    private fun getInstanceOfFireStoreDb(): FirebaseFirestore {
        val fireStoreDataBase = FirebaseFirestore.getInstance()
        val settings = FirebaseFirestoreSettings.Builder()
            .setTimestampsInSnapshotsEnabled(true)
            .build()

        fireStoreDataBase.firestoreSettings = settings
        return fireStoreDataBase
    }

    override fun getOrder(): Observable<Order> {
        return Observable.create<Order> { emitter ->
            ordersCollection
                .whereEqualTo("userId", "BqUbmkLdd8M24VQ6VaKibzZD1ZJ2")
                .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                    if (querySnapshot != null) {
                        val orders = ArrayList<Order>()
                        var quantity = 0
                        Log.i("LISTENER", "size " + orders.size)

                        for (doc in querySnapshot) {
                            val order = doc.toObject(Order::class.java)!!
                            emitter.onNext(order)
                            }
                    }
                           /* order.orderId = doc.id
                            Log.i("ID_IN_LISTENER", "order_id " + order.orderId)
                            Log.i("ID_IN_LISTENER", "description " + order.description)
                            if (order.relatedReportsIds != null) {
                                order.relatedReportsIds = doc.get("relatedReportsIds") as ArrayList<String>
                            }
                            orders.add(order)*/
                            } //subscribeOn(Schedulers.io())
                    }
                }

    }


