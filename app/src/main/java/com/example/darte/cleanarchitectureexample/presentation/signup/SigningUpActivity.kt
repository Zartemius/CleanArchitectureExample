package com.example.darte.cleanarchitectureexample.presentation.signup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.darte.cleanarchitectureexample.R

class SigningUpActivity : AppCompatActivity(),SigningUpView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signing_up)
    }
}
