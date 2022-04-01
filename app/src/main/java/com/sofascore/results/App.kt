package com.sofascore.results

import androidx.multidex.MultiDexApplication
import com.google.android.gms.ads.MobileAds


class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)
    }
}