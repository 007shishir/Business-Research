package com.mme.saif_win10.businessresearch;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.mme.saif_win10.businessresearch.interFace.Iinterstitial_Ad;

/**
 * The class "Interstitial_ad was create to facilitate the Interstitial ad
 * to other activity and fragment
 * Implements interface {@link Iinterstitial_Ad}
 * There are three method:
 * {@link #createInterstitial()} - for initializing ad
 * {@link #loadInterstitial()} - to load an ad
 * {@link #showInterstitial()} - to show the ad
 * @author Saiful Islam
 * @since 12 March 2020"
 * @version 1.0
 * @deprecated 22 nov 2020
 */
public class Interstitial_ad implements Iinterstitial_Ad {
    private com.google.android.gms.ads.InterstitialAd mInterstitialAd;
    private Context context;
//    private static final String TAG = "Interstitial_ad Class";

    /**
     * This is the Constructor should be used to recieve context
     * @param context receives application context
     */
    public Interstitial_ad(Context context) {
        this.context = context;
    }

    /**
     * This method should be called to initialize Interstitial ad
     * does not return anything or receive any param
     * Banner ID should be here not in the String values
     * initializing interstitial ad
     */

    @Override
    public void createInterstitial() {
//        mInterstitialAd = new com.google.android.gms.ads.InterstitialAd(context);
//        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        //Below is for the TEST purpose only
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdUnitId("ca-app-pub-2522810443010389/6580857976");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // not call show interstitial ad from here
//                Log.d(TAG, "successfully ad loaded");
            }

            @Override
            public void onAdClosed() {
                loadInterstitial();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
//                Log.d(TAG, "Failed"+i);
            }
        });
        loadInterstitial();
    }

    /**
     * send request through AdRequest to load Interstitial ad
     * no return no param
     */
    @Override
    public void loadInterstitial() {
        AdRequest interstitialRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(interstitialRequest);
    }

    /**
     * Used to show interstitial ad
     */
    @Override
    public void showInterstitial() {

        if (mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
//            Log.d(TAG, "Congratulation, Ad is loaded");
        }
        else
        {
            loadInterstitial();
//            Log.d(TAG, "Ad not loaded, reason unknown");
        }

    }
}
