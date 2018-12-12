package com.example.darte.cleanarchitectureexample.domain

import com.example.darte.cleanarchitectureexample.data.DeviceLocationSource

class GetLocationUseCase(deviceLocationSource:DeviceLocationSource){

    val mDeviceLocationSource:DeviceLocationSource

    init{
        mDeviceLocationSource = deviceLocationSource
    }

    fun getDeviceLocation():String{
        return mDeviceLocationSource.getDeviceLocationKt()
    }
}