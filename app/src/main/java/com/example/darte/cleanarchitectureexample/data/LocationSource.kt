package com.example.darte.cleanarchitectureexample.data

class LocationSource:DeviceLocationSource{

    val mLocation = "Saint-Petersburg"

    override fun getDeviceLocationKt(): String {
        return mLocation
    }
}