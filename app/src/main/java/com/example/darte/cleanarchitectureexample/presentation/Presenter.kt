package com.example.darte.cleanarchitectureexample.presentation

import android.util.Log
import com.example.darte.cleanarchitectureexample.data.DataBase
import com.example.darte.cleanarchitectureexample.data.DatabaseListener
import com.example.darte.cleanarchitectureexample.domain.GetLocationUseCase
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class Presenter(getLocationUseCase: GetLocationUseCase,database:DataBase){

    val mGetLocationUseCase:GetLocationUseCase
    val mDataBase:DataBase

    var mView:MainView? = null
    lateinit var disposable:Disposable

    init{
        mGetLocationUseCase = getLocationUseCase
        mDataBase = database
    }

    fun onViewCreated(mainView:MainView){
        mView = mainView
    }

    fun onButtonPressed(){
       val message =  mGetLocationUseCase.getDeviceLocation()
        disposable = message.observeOn(AndroidSchedulers.mainThread())
            .subscribe{ result ->
                Log.i("EMITTER", "result _2"+ result)

            }
        val order = mDataBase.getOrder()
        order.observeOn(AndroidSchedulers.mainThread())
            .subscribe{result ->
                Log.i("ORDER_EMITTER", "result "+ result.description)
                mView!!.showLocation(result.description!!)
            }
    }

    fun onDestroy(){
        mView = null
        disposable.dispose()
    }
}