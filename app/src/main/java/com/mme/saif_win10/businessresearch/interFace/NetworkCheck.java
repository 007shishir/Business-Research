package com.mme.saif_win10.businessresearch.interFace;

public interface NetworkCheck {
    boolean isNetworkAvailable();
    void notifyUser(boolean connectNetwork);
}
