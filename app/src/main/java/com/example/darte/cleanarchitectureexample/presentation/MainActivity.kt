package com.example.darte.cleanarchitectureexample.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.darte.cleanarchitectureexample.R
import com.example.darte.cleanarchitectureexample.data.LocationSource
import com.example.darte.cleanarchitectureexample.domain.GetLocationUseCase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {

    val dataSource = LocationSource()
    val mPresenter = Presenter(GetLocationUseCase(dataSource))

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
