package com.example.darte.cleanarchitectureexample

import android.app.Application
import com.example.darte.cleanarchitectureexample.dagger.AppComponent
import com.example.darte.cleanarchitectureexample.dagger.AppModule
import com.example.darte.cleanarchitectureexample.dagger.DaggerAppComponent

class ECDApplication:Application() {

    lateinit var ecdComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        ecdComponent = initDagger(this)
    }

    private fun initDagger(app: ECDApplication): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()
}