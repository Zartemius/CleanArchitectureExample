package com.example.darte.cleanarchitectureexample.data

import com.example.darte.cleanarchitectureexample.domain.models.Order
import com.google.firebase.firestore.QuerySnapshot
import io.reactivex.Observable

interface LiveDataBaseRepository{

    fun getOrder():Observable<ArrayList<Order>>
}