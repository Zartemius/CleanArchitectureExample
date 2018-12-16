package com.example.darte.cleanarchitectureexample.domain.usecases

import com.example.darte.cleanarchitectureexample.data.LiveDataBaseRepository
import com.example.darte.cleanarchitectureexample.domain.mappers.OrderMapper
import com.example.darte.cleanarchitectureexample.domain.models.Order
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class OrderDataUseCase @Inject constructor(liveDataBaseRepository: LiveDataBaseRepository){


    val mLiveDataBaseRepository:LiveDataBaseRepository

    init{
        mLiveDataBaseRepository = liveDataBaseRepository
    }

    fun getLiveOrderData():Observable<Order>{
        val receivedOrders = mLiveDataBaseRepository.getOrder()
        return receivedOrders.map { orders ->
            OrderMapper.getActualOrder(orders)
        }.observeOn(AndroidSchedulers.mainThread())
    }
}