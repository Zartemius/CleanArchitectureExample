package com.example.darte.cleanarchitectureexample.presentation

import com.example.darte.cleanarchitectureexample.domain.GetLocationUseCase

class Presenter(getLocationUseCase: GetLocationUseCase){

    val mGetLocationUseCase:GetLocationUseCase

    var mView:MainView? = null

    init{
        mGetLocationUseCase = getLocationUseCase
    }

    fun onViewCreated(mainView:MainView){
        mView = mainView
    }

    fun onButtonPressed(){
        val location = mGetLocationUseCase.getDeviceLocation()
        mView!!.showLocation(location)
    }

    fun onDestroy(){
        mView = null
    }
}