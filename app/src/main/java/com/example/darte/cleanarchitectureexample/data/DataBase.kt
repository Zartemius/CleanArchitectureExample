package com.example.darte.cleanarchitectureexample.data

import com.example.darte.cleanarchitectureexample.domain.models.Order
import io.reactivex.Observable

interface DataBase{

    fun getOrder():Observable<Order>
}