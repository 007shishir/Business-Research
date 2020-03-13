package com.mme.saif_win10.businessresearch;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
import com.mme.saif_win10.businessresearch.interFace.NetworkCheck;

/**
 * This class check internet/network
 * it overrides two methods from interface {@link NetworkCheck}
 * methods: {@link CheckingNetwork#isNetworkAvailable()} and {@link CheckingNetwork#notifyUser(boolean)}
 * @author Saiful Islam
 * @since 12 March 2020
 * @version 1.1
 */

public class CheckingNetwork implements NetworkCheck {
    private Context context;

    public CheckingNetwork(Context context) {
        this.context = context;
    }

    /**
     * This method should be called first - initialization
     * @return true if network available, false otherwise
     */
    @Override
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * This method notify USER about the network connection
     * @param connectNetwork true if network available, false otherwise
     */
    @Override
    public void notifyUser(boolean connectNetwork) {
        if (connectNetwork){
            Toast.makeText(context, "Network Available!", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(context, "Network Not Available!", Toast.LENGTH_SHORT).show();
    }

    /**
     * This method notify user through Snackbar
     * @since 13 March 2020
     * @param connectNetwork whether network is on or not
     * @param view receives view from the other class/activity
     */
    public void notifyUser_Snackbar(boolean connectNetwork, View view) {
        if (connectNetwork){
            Snackbar.make(view, "Internet is Available...", Snackbar.LENGTH_LONG).show();
        }else
            Snackbar.make(view, "No Network Connection...", Snackbar.LENGTH_LONG).show();
    }

}
