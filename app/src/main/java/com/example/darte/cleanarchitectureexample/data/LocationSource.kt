package com.example.darte.cleanarchitectureexample.data

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class LocationSource:DeviceLocationSource{

    val mLocation = "Saint-Petersburg"
    val list = ArrayList<String>()



    private fun fillList(){
        list.add("Hi")
        list.add("Listen")
        list.add("to")
        list.add("your")
        list.add("heart")
    }

    override fun getDeviceLocationKt(): Observable<String> {
        return Observable.create<String> { emitter ->
            fillList()
            for(i in list) {
                Thread.sleep(1000)
                emitter.onNext(i)
                Log.i("EMITTER", "result"+ i)
            }
        }.subscribeOn(Schedulers.io())
    }
}