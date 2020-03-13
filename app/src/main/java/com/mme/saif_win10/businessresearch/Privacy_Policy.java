package com.mme.saif_win10.businessresearch;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
//import android.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * @author Saiful Islam
 * @since 13 March 2020
 * @version 1.0
 */
public class Privacy_Policy extends Fragment {

    public Privacy_Policy() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_web_view__theory, container, false);

        String url = "file:///android_asset/privacy_policy.html";
        WebView mWeb_one = view.findViewById(R.id.mWeb_one);
        mWeb_one.getSettings().setBuiltInZoomControls(true);
        mWeb_one.loadUrl(url);

        return view;
    }
}
