package com.example.darte.cleanarchitectureexample.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.darte.cleanarchitectureexample.R
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainScreen : AppCompatActivity(),MainView {

    //val mLiveDataBase = LiveDataBase()
    @Inject
    lateinit var mMainScreenPresenter:MainScreenPresenter
    //= MainScreenPresenter(OrderDataUseCase(mLiveDataBase))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainScreenPresenter.onViewCreated(this)

        setLocationButton.setOnClickListener {
            mMainScreenPresenter.onButtonPressed()
        }
    }

    override fun showLocation(location: String) {
        locationMessage.text = location
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainScreenPresenter.onDestroy()
    }
}
