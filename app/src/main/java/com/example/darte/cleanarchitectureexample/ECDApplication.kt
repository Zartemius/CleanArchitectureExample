package com.example.darte.cleanarchitectureexample

import android.app.Application
import android.content.Context
import com.example.darte.cleanarchitectureexample.dagger.AppComponent
import com.example.darte.cleanarchitectureexample.dagger.AppModule
import com.example.darte.cleanarchitectureexample.dagger.DaggerAppComponent


class ECDApplication:Application() {

    lateinit var ecdComponent: AppComponent

    /*companion object{
        private var mAppContext:Context?  = null

        @Synchronized fun getAppContext():Context{
            return mAppContext!!
        }
    }*/

    override fun onCreate() {
        super.onCreate()
        // mAppContext = applicationContext

        ecdComponent = initDagger(this)
    }

    private fun initDagger(app: ECDApplication): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()
}