package com.example.darte.cleanarchitectureexample.router

import android.content.Context
import android.content.Intent
import com.example.darte.cleanarchitectureexample.presentation.mainscreen.MainScreenActivity
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    companion object {
        class MainScreen:SupportAppScreen(){
            override fun getActivityIntent(context: Context?):Intent {
                return Intent(context, MainScreenActivity::class.java)
            }
        }
    }
}