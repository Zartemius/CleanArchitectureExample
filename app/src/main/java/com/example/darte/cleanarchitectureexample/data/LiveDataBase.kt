package com.example.darte.cleanarchitectureexample.data

import com.example.darte.cleanarchitectureexample.data.models.Order
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlin.collections.ArrayList

class LiveDataBase:LiveDataBaseRepository {

    private val collectionPath = "orders"
    private val field = "userId"
    private val fieldValue = "BqUbmkLdd8M24VQ6VaKibzZD1ZJ2"



    private val ordersCollection: CollectionReference = getInstanceOfFireStoreDb()
        .collection(collectionPath)

    private fun getInstanceOfFireStoreDb(): FirebaseFirestore {
        val fireStoreDataBase = FirebaseFirestore.getInstance()
        val settings = FirebaseFirestoreSettings.Builder()
            .setTimestampsInSnapshotsEnabled(true)
            .build()

        fireStoreDataBase.firestoreSettings = settings
        return fireStoreDataBase
    }

    override fun getOrder(): Observable<ArrayList<Order>> {
        return Observable.create<ArrayList<Order>> { emitter ->
            ordersCollection
                .whereEqualTo(field,fieldValue)
                .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                    if (querySnapshot != null) {
                        val orders = ArrayList<Order>()

                        for (doc in querySnapshot) {
                            orders.add(doc.toObject(Order::class.java))
                        }

                        emitter.onNext(orders)
                    }

                           /* order.orderId = doc.id
                            Log.i("ID_IN_LISTENER", "order_id " + order.orderId)
                            Log.i("ID_IN_LISTENER", "description " + order.description)
                            if (order.relatedReportsIds != null) {
                                order.relatedReportsIds = doc.get("relatedReportsIds") as ArrayList<String>
                            }
                            orders.add(order)*/
                }

        }.subscribeOn(Schedulers.io())
    }
}


