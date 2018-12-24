package com.example.darte.cleanarchitectureexample.presentation.mainscreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.darte.cleanarchitectureexample.ECDApplication
import com.example.darte.cleanarchitectureexample.R
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainScreenActivity : AppCompatActivity(), MainScreenView {

    @Inject lateinit var mMainScreenPresenter: MainScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as ECDApplication).ecdComponent.inject(this)

        setLocationButton.setOnClickListener {
            mMainScreenPresenter.onButtonPressed()
        }
    }

    override fun onResume() {
        super.onResume()
        mMainScreenPresenter.subscribe(this)
    }

    override fun onPause() {
        super.onPause()
        mMainScreenPresenter.unsubscribe()
    }

    override fun showLocation(location: String) {
        locationMessage.text = location
    }

}
