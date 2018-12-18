package com.example.darte.cleanarchitectureexample.data.livedatabase

import com.example.darte.cleanarchitectureexample.domain.models.Order
import io.reactivex.Observable

interface LiveDataBaseRepository{

    fun getOrder():Observable<ArrayList<Order>>
}