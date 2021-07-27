package com.example.pizzapalace

import android.app.Application
import timber.log.Timber

class PizzaPalace : Application(){
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}