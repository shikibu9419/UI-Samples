package com.example.shikibu.ui_samples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.app_bar_main.*

class BasicCoordinatorActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_coordinator)
        setSupportActionBar(toolbar)
    }
}