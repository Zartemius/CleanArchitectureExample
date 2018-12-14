package com.example.darte.cleanarchitectureexample.presentation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.darte.cleanarchitectureexample.R
import com.example.darte.cleanarchitectureexample.data.DataBase
import com.example.darte.cleanarchitectureexample.data.DatabaseListener
import com.example.darte.cleanarchitectureexample.data.LocationSource
import com.example.darte.cleanarchitectureexample.domain.GetLocationUseCase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {

    val dataSource = LocationSource()
    val dataBase= DatabaseListener()
    val mPresenter = Presenter(GetLocationUseCase(dataSource),dataBase)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter.onViewCreated(this)

        setLocationButton.setOnClickListener {
            mPresenter.onButtonPressed()
        }
    }

    override fun showLocation(location: String) {
        locationMessage.text = location
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }
}
