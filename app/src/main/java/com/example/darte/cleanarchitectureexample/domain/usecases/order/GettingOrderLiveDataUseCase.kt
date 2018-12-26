package com.example.darte.cleanarchitectureexample.domain.usecases.order

import com.example.darte.cleanarchitectureexample.data.database.LiveDataBaseRepository
import com.example.darte.cleanarchitectureexample.domain.mappers.OrderMapper
import com.example.darte.cleanarchitectureexample.domain.models.Order
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class GettingOrderLiveDataUseCase @Inject constructor(private val liveDataBaseRepository: LiveDataBaseRepository){

    //lateinit var mLiveDataBaseRepository:LiveDataBaseRepository

    /*init{
        mLiveDataBaseRepository = liveDataBaseRepository
    }*/

    fun getLiveOrderData():Observable<Order>{
        val receivedOrders = liveDataBaseRepository.getOrder()
        return receivedOrders.map { orders ->
            OrderMapper.getActualOrder(orders)
        }.observeOn(AndroidSchedulers.mainThread())
    }
}