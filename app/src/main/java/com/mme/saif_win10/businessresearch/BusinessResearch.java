package com.mme.saif_win10.businessresearch;

import android.app.Application;
import com.google.firebase.database.FirebaseDatabase;

public class BusinessResearch extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
