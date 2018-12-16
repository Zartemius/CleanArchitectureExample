package com.example.darte.cleanarchitectureexample.presentation

import android.util.Log
import com.example.darte.cleanarchitectureexample.domain.usecases.OrderDataUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainScreenPresenter @Inject constructor(orderDataUseCase: OrderDataUseCase){

    val mOrderDataUseCase: OrderDataUseCase

    var mView:MainView? = null
    lateinit var disposable:Disposable

    init{
        mOrderDataUseCase = orderDataUseCase
    }

    fun onViewCreated(mainView:MainView){
        mView = mainView
    }

    fun onButtonPressed(){
        val order = mOrderDataUseCase.getLiveOrderData()
        disposable = order.observeOn(AndroidSchedulers.mainThread())
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