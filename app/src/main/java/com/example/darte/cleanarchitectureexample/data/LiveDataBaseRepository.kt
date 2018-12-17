package com.example.darte.cleanarchitectureexample.data

import com.example.darte.cleanarchitectureexample.data.models.Order
import io.reactivex.Observable

interface LiveDataBaseRepository{

    fun getOrder():Observable<ArrayList<Order>>
}