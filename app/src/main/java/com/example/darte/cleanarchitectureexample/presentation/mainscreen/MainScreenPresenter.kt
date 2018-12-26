package com.example.darte.cleanarchitectureexample.presentation.mainscreen

import android.util.Log
import com.example.darte.cleanarchitectureexample.domain.usecases.order.GettingOrderLiveDataUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainScreenPresenter @Inject constructor(private val gettingOrderLiveDataUseCase: GettingOrderLiveDataUseCase){

    private var mScreenView: MainScreenView? = null
    lateinit var disposable:Disposable

    fun subscribe(mainScreenView: MainScreenView){
        mScreenView = mainScreenView
    }

    fun unsubscribe(){
        mScreenView = null
        disposable.dispose()
    }

    fun onButtonPressed(){
        val order = gettingOrderLiveDataUseCase.getLiveOrderData()
        disposable = order.observeOn(AndroidSchedulers.mainThread())
            .subscribe{result ->
                Log.i("ORDER_EMITTER", "result "+ result.description)
                mScreenView!!.showLocation(result.description!!)
            }
    }
}