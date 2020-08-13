package com.looking.logging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.lifecycle.LifecycleObserver
import com.example.android.dessertpusher.DessertTimer
import timber.log.Timber
import java.sql.Time
import kotlin.math.log

const val KEY_REVENUE = "key_revenue"

class MainActivity : AppCompatActivity(), LifecycleObserver {

    private var revenue = 0
    lateinit var dessertTimer: DessertTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MainActivity", "onCreate called")

        dessertTimer = DessertTimer(this.lifecycle)
        if (null != savedInstanceState) {
            Timber.i("go here")
            revenue = savedInstanceState.getInt(KEY_REVENUE, 0)
            Toast.makeText(applicationContext, revenue.toString(), Toast.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()

        Timber.i("onStart Called")
//        dessertTimer.startTimer()
        revenue = 10
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.i("onSaveInstanceState Called")
        outState.putInt(KEY_REVENUE, revenue)
    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        Timber.i("onRestoreInstanceState Called")
//    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")

    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called")

    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")

//        dessertTimer.stopTimer()
    }
}
