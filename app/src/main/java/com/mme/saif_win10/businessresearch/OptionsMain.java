package com.mme.saif_win10.businessresearch;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionsMain extends Fragment implements View.OnClickListener {

    View view;
    TextView cTxt_one, cTxt_two, cTxt_three, cTxt_four, cTxt_five, cTxt_six, cTxt_seven, cTxt_eight;
    LinearLayout mLL_full_view;
    String url;
    FragmentTransaction fr;


    public OptionsMain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_options_main, container, false);

        cTxt_one = view.findViewById(R.id.cTxt_one);
        cTxt_one.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cTxt_one:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new WebView_Theory());
                fr.addToBackStack(null).commit();
                break;
            default:
                Toast.makeText(getContext(), "error in OptionMain", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
