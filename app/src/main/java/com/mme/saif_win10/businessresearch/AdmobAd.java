package com.mme.saif_win10.businessresearch;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 *This class receives an AdView object and initialize the banner ad
 * Constructor {@link AdmobAd#AdmobAd(AdView)}
 * It has one method {@link AdmobAd#bannerAd_initialize()}
 * @author Saiful Islam
 * @since 12 March 2020
 * @version 1.0
 */

public class AdmobAd {
    private final AdView adView;

    /**
     * This is the constructor should be called to use this class for the first time
     * @param adView an object of AdView Class
     */
    //Constructor for banner ad
    public AdmobAd(AdView adView) {
        this.adView = adView;
    }


    /**
     * This method initialize banner ad
     */
    public void bannerAd_initialize(){
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
    }
}
