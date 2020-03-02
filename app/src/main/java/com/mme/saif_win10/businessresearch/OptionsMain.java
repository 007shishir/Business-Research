package com.mme.saif_win10.businessresearch;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.mme.saif_win10.businessresearch.mcqRoomDatabase.McqRecV;
import com.mme.saif_win10.businessresearch.memorizeRoomDatabase.MemorizeRecV;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionsMain extends Fragment implements View.OnClickListener {

    View view;
    private TextView cTxt_one, cTxt_two, cTxt_three, cTxt_four, cTxt_five, cTxt_six, cTxt_seven, cTxt_eight,
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

//        MobileAds.initialize(getActivity(),
//                "ca-app-pub-2522810443010389~4731706529");

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
        String url_string;
        switch (v.getId()) {
            case R.id.cTxt_one:
                url_string = "file:///android_asset/Chapter1.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_two:
                url_string = "file:///android_asset/Chapter2.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_three:
                url_string = "file:///android_asset/Chapter3.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_four:
                url_string = "file:///android_asset/Chapter4.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_five:
                url_string = "file:///android_asset/Chapter5.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_six:
                url_string = "file:///android_asset/Chapter6.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_seven:
                url_string = "file:///android_asset/Chapter7.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_eight:
                url_string = "file:///android_asset/Chapter8.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.mTxt_mcq:
                NavDirections mcq_action = OptionsMainDirections
                        .actionOptionsMainToMcqRecV();
                Navigation.findNavController(v).navigate(mcq_action);
                break;
            case R.id.mTxt_memorize:
                NavDirections mem_action = OptionsMainDirections
                        .actionOptionsMainToMemorizeRecV();
                Navigation.findNavController(v).navigate(mem_action);
                break;
            case R.id.cTxt_nine:
                url_string = "file:///android_asset/Chapter9.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_ten:
                url_string = "file:///android_asset/Chapter10.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_11:
                url_string = "file:///android_asset/Chapter11.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_12:
                url_string = "file:///android_asset/Chapter12.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_13:
                url_string = "file:///android_asset/Chapter13.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_14:
                url_string = "file:///android_asset/Chapter14.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_15:
                url_string = "file:///android_asset/Chapter15.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_16:
                url_string = "file:///android_asset/Chapter16.html";
                fragmentTransaction(v, url_string);
                break;
            default:
                Toast.makeText(getContext(), "error in OptionMain", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private static void fragmentTransaction(View view, String getUrl){
        Bundle url = new Bundle();
        url.putString("url", getUrl);
        Navigation.findNavController(view).navigate(R.id.action_optionsMain_to_webView_Theory, url);
    }
}
