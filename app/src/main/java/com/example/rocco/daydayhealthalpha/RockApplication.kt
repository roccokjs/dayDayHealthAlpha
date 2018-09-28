package com.example.rocco.daydayhealthalpha

import android.app.Application
import android.util.Log
import com.facebook.stetho.Stetho

class RockApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)

        Log.wtf("Tag", "APplication onCreate is called")
    }

}
