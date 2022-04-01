package com.sofascore.results

import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.google.android.gms.ads.admanager.AdManagerAdView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)
        requestGoogleAds(findViewById(R.id.ads_view_container))
    }

    private fun requestGoogleAds(container: ViewGroup, adSize: AdSize = AdSize.BANNER) {
        container.visibility = VISIBLE
        container.minimumHeight = adSize.getHeightInPixels(this)
        val googleAdView = AdManagerAdView(this)
        googleAdView.setAdSizes(adSize)
        googleAdView.adUnitId = "/6499/example/banner"
        googleAdView.adListener = object : AdListener() {
            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                container.visibility = View.GONE
            }
        }
        container.addView(googleAdView)
        val adRequest = AdManagerAdRequest.Builder()
        googleAdView.loadAd(adRequest.build())
    }

}