package com.hidevelopers.sharepal.presentation//package com.hidevelopers.sharepal.presentation

import android.app.Application
//import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

//@HiltAndroidApp
class BaseApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}