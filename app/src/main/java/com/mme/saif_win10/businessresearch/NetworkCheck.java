package com.mme.saif_win10.businessresearch;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.google.android.material.snackbar.Snackbar;

/**
 * This class check network
 * it's constructor receive context
 * @deprecated
 * @since 12 March 2020
 */
class NetworkCheck {
    private Context context;
    //    private ConnectivityManager mCManager;
//    private ConnectivityManager.NetworkCallback mCallBack;

    NetworkCheck() {
    }

    NetworkCheck(Context context) {
        this.context = context;
    }

    //Checking network Connection

    void isNetworkAvailable(ConnectivityManager.NetworkCallback mCallBack, NetworkRequest request,
                            ConnectivityManager mCManaager, final View view) {
//        ConnectivityManager mCManager = (ConnectivityManager)
//                context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkRequest request = new NetworkRequest.Builder().build();
        mCallBack = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onLost(@NonNull Network network) {
                //Showing alertDialog when network is lost

                Toast.makeText(context, "Make sure you have active internet connection",
                        Toast.LENGTH_SHORT).show();
                Snackbar.make(view, "No Network Connection...", Snackbar.LENGTH_INDEFINITE).show();
            }

            @Override
            public void onAvailable(@NonNull Network network) {

                Toast.makeText(context, "Internet Available!",
                        Toast.LENGTH_SHORT).show();
                Snackbar.make(view, "Internet Available...", Snackbar.LENGTH_SHORT).show();

//                super.onAvailable(network);
            }

        };
        assert mCManaager != null;
        mCManaager.registerNetworkCallback(request, mCallBack);
    }


//    void unregister_NetworkCallback(ConnectivityManager mCManager){
//        mCManager.unregisterNetworkCallback(mCallBack);
//    }

}
