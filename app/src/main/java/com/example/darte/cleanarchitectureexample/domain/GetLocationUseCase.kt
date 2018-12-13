package com.example.darte.cleanarchitectureexample.domain

import com.example.darte.cleanarchitectureexample.data.DeviceLocationSource
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

class GetLocationUseCase(deviceLocationSource:DeviceLocationSource){

    val mDeviceLocationSource:DeviceLocationSource

    init{
        mDeviceLocationSource = deviceLocationSource
    }

    fun getDeviceLocation():Observable<String>{
        return mDeviceLocationSource.getDeviceLocationKt()
    }
}