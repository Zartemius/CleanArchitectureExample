package com.example.darte.cleanarchitectureexample.presentation

import android.util.Log
import com.example.darte.cleanarchitectureexample.domain.GetLocationUseCase
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
       val message =  mGetLocationUseCase.getDeviceLocation()
        message.observeOn(AndroidSchedulers.mainThread())
            .subscribe{ result ->
                Log.i("EMITTER", "result _2"+ result)
                mView!!.showLocation(result)
            }
    }

    fun onDestroy(){
        mView = null
    }
}