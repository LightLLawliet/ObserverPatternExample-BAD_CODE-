package com.example.observerpatternexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    val observable: MapObservable = MapObservable.Base()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("1232","onCreate started")
        supportFragmentManager.beginTransaction().replace(R.id.container, FirstFragment()).commit()
    }
}