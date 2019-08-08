package com.mme.saif_win10.businessresearch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.mme.saif_win10.businessresearch.memorizeRoomDatabase.MemorizeRecV;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionsMain extends Fragment implements View.OnClickListener {

    View view;
    TextView cTxt_one, cTxt_two, cTxt_three, cTxt_four, cTxt_five, cTxt_six, cTxt_seven, cTxt_eight,
            cTxt_nine, cTxt_ten, cTxt_11, cTxt_12, cTxt_13, cTxt_14, cTxt_15, cTxt_16, mTxt_mcq, mTxt_memorize;
    LinearLayout mLL_full_view;
    String url;
    FragmentTransaction fr;
    private AdView add_banner_one, add_banner_two;


    public OptionsMain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_options_main, container, false);

        cTxt_one = view.findViewById(R.id.cTxt_one);
        cTxt_two = view.findViewById(R.id.cTxt_two);
        cTxt_three = view.findViewById(R.id.cTxt_three);
        cTxt_four = view.findViewById(R.id.cTxt_four);
        cTxt_five = view.findViewById(R.id.cTxt_five);
        cTxt_six = view.findViewById(R.id.cTxt_six);
        cTxt_seven = view.findViewById(R.id.cTxt_seven);
        cTxt_eight = view.findViewById(R.id.cTxt_eight);


        cTxt_nine = view.findViewById(R.id.cTxt_nine);
        cTxt_ten = view.findViewById(R.id.cTxt_ten);
        cTxt_11 = view.findViewById(R.id.cTxt_11);
        cTxt_12 = view.findViewById(R.id.cTxt_12);
        cTxt_13 = view.findViewById(R.id.cTxt_13);
        cTxt_14 = view.findViewById(R.id.cTxt_14);
        cTxt_15 = view.findViewById(R.id.cTxt_15);
        cTxt_16 = view.findViewById(R.id.cTxt_16);

        mTxt_mcq = view.findViewById(R.id.mTxt_mcq);
        mTxt_memorize = view.findViewById(R.id.mTxt_memorize);

        MobileAds.initialize(getActivity(),
                "ca-app-pub-3940256099942544~3347511713");

        add_banner_one = view.findViewById(R.id.add_banner_one);
        add_banner_two = view.findViewById(R.id.add_banner_two);
        AdRequest adRequest = new AdRequest.Builder().build();
        add_banner_one.loadAd(adRequest);
        add_banner_two.loadAd(adRequest);

        cTxt_one.setOnClickListener(this);
        cTxt_two.setOnClickListener(this);
        cTxt_three.setOnClickListener(this);
        cTxt_four.setOnClickListener(this);
        cTxt_five.setOnClickListener(this);
        cTxt_six.setOnClickListener(this);
        cTxt_seven.setOnClickListener(this);
        cTxt_eight.setOnClickListener(this);

        cTxt_nine.setOnClickListener(this);
        cTxt_ten.setOnClickListener(this);
        cTxt_11.setOnClickListener(this);
        cTxt_12.setOnClickListener(this);
        cTxt_13.setOnClickListener(this);
        cTxt_14.setOnClickListener(this);
        cTxt_15.setOnClickListener(this);
        cTxt_16.setOnClickListener(this);

        mTxt_mcq.setOnClickListener(this);
        mTxt_memorize.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cTxt_one:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter1());
                fr.addToBackStack(null).commit();
                break;
            case R.id.cTxt_two:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter2());
                fr.addToBackStack(null).commit();
                break;
            case R.id.cTxt_three:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter3());
                fr.addToBackStack(null).commit();
                break;
            case R.id.cTxt_four:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter4());
                fr.addToBackStack(null).commit();
                break;
            case R.id.cTxt_five:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter5());
                fr.addToBackStack(null).commit();
                break;
            case R.id.cTxt_six:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter6());
                fr.addToBackStack(null).commit();
                break;
            case R.id.cTxt_seven:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter7());
                fr.addToBackStack(null).commit();
                break;
            case R.id.cTxt_eight:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter8());
                fr.addToBackStack(null).commit();
                break;
            case R.id.mTxt_mcq:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new McqRecV());
                fr.addToBackStack(null).commit();
                break;
            case R.id.mTxt_memorize:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new MemorizeRecV());
                fr.addToBackStack(null).commit();
                break;
            case R.id.cTxt_nine:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter9());
                fr.addToBackStack(null).commit();
                break;
            case R.id.cTxt_ten:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter10());
                fr.addToBackStack(null).commit();
                break;
            case R.id.cTxt_11:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter11());
                fr.addToBackStack(null).commit();
                break;
            case R.id.cTxt_12:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter12());
                fr.addToBackStack(null).commit();
                break;
            case R.id.cTxt_13:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter13());
                fr.addToBackStack(null).commit();
                break;
            case R.id.cTxt_14:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter14());
                fr.addToBackStack(null).commit();
                break;
            case R.id.cTxt_15:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter15());
                fr.addToBackStack(null).commit();
                break;
            case R.id.cTxt_16:
                fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Chapter16());
                fr.addToBackStack(null).commit();
                break;
            default:
                Toast.makeText(getContext(), "error in OptionMain", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
