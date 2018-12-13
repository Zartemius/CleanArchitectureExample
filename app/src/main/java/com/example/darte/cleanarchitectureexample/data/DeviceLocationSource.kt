package com.example.darte.cleanarchitectureexample.data

import io.reactivex.Observable

interface DeviceLocationSource {

    fun getDeviceLocationKt():Observable<String>
}