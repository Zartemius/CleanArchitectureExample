package com.example.darte.cleanarchitectureexample.data

import com.example.darte.cleanarchitectureexample.domain.models.Order
import io.reactivex.Observable

interface DeviceLocationSource {

    fun getDeviceLocationKt():Observable<String>
}