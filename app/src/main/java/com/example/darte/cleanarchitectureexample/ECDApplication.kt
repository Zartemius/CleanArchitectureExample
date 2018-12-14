package com.example.darte.cleanarchitectureexample

import android.app.Application
import android.content.Context

class ECDApplication:Application(){

    companion object{
        private var mAppContext:Context?  = null

        @Synchronized fun getAppContext():Context{
            return mAppContext!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        mAppContext = applicationContext
    }
}