package com.mme.saif_win10.businessresearch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
//import android.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class InstructionFragment extends Fragment {

    WebView mWeb_one;
    View view;
    String url;
    public InstructionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_web_view__theory, container, false);

        url = "file:///android_asset/instruction.html";
        mWeb_one = view.findViewById(R.id.mWeb_one);
        mWeb_one.getSettings().setBuiltInZoomControls(true);
        mWeb_one.loadUrl(url);

        return view;
    }
}
