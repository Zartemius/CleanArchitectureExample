package com.example.darte.cleanarchitectureexample.router

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.darte.cleanarchitectureexample.presentation.mainscreen.MainScreenActivity
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    companion object {

        class MainScreen:SupportAppScreen(){
            override fun getActivityIntent(context: Context?):Intent {
                Log.i("SPLASH_TEST", "border_three")
                return Intent(context, MainScreenActivity::class.java)
            }
        }
    }
}