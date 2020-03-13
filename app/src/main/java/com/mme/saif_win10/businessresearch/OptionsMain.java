package com.mme.saif_win10.businessresearch;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdView;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 * This fragment implements interface {@link View.OnClickListener}
 * @author Saiful Islam
 * @since 12 March 2020
 * @version 1.1
 */
public class OptionsMain extends Fragment implements View.OnClickListener {

    private View view;
    private Interstitial_ad interstitialAd;


    public OptionsMain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_options_main, container, false);

        initializing_setonClickListener_on_TextView();

        //for loading banner ad
        bannerAdLoad();
        //loading interstitial ad
        callingAndLoading_interstitialAd();

        return view;
    }

    /**
     * This method initialize all textView
     * And SetOnClickListener on those TextView
     * @author Saiful Islam
     * @since 13 March 2020
     */
    private void initializing_setonClickListener_on_TextView() {
        TextView cTxt_one = view.findViewById(R.id.cTxt_one);
        TextView cTxt_two = view.findViewById(R.id.cTxt_two);
        TextView cTxt_three = view.findViewById(R.id.cTxt_three);
        TextView cTxt_four = view.findViewById(R.id.cTxt_four);
        TextView cTxt_five = view.findViewById(R.id.cTxt_five);
        TextView cTxt_six = view.findViewById(R.id.cTxt_six);
        TextView cTxt_seven = view.findViewById(R.id.cTxt_seven);
        TextView cTxt_eight = view.findViewById(R.id.cTxt_eight);

        TextView cTxt_nine = view.findViewById(R.id.cTxt_nine);
        TextView cTxt_ten = view.findViewById(R.id.cTxt_ten);
        TextView cTxt_11 = view.findViewById(R.id.cTxt_11);
        TextView cTxt_12 = view.findViewById(R.id.cTxt_12);
        TextView cTxt_13 = view.findViewById(R.id.cTxt_13);
        TextView cTxt_14 = view.findViewById(R.id.cTxt_14);
        TextView cTxt_15 = view.findViewById(R.id.cTxt_15);
        TextView cTxt_16 = view.findViewById(R.id.cTxt_16);

        TextView mTxt_mcq = view.findViewById(R.id.mTxt_mcq);
        TextView mTxt_memorize = view.findViewById(R.id.mTxt_memorize);

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
    }

    /**
     * This method call class {@link Interstitial_ad}
     * And load an Interstitial Ad
     * No Param and No return
     * @since 13 March 2020
     * @author Saiful Islam
     */
    private void callingAndLoading_interstitialAd() {
        //for loading interstitial ad
        interstitialAd = new Interstitial_ad(Objects.requireNonNull(getContext()));
        interstitialAd.createInterstitial();
        interstitialAd.loadInterstitial();
    }

    /**
     * This method load banner to View
     * @since 13 March 2020
     * @author Saiful Islam
     */
    private void bannerAdLoad() {
        //initialization of banner ad
        AdmobAd admobAd = new AdmobAd((AdView) view.findViewById(R.id.add_banner_one));
        admobAd.bannerAd_initialize();
    }

    @Override
    public void onClick(View v) {
        String url_string;
        switch (v.getId()) {
            case R.id.cTxt_one:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter1.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_two:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter2.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_three:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter3.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_four:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter4.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_five:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter5.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_six:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter6.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_seven:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter7.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_eight:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter8.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.mTxt_mcq:
                interstitialAd.showInterstitial();
                NavDirections mcq_action = OptionsMainDirections
                        .actionOptionsMainToMcqRecV();
                Navigation.findNavController(v).navigate(mcq_action);
                break;
            case R.id.mTxt_memorize:
                interstitialAd.showInterstitial();
                NavDirections mem_action = OptionsMainDirections
                        .actionOptionsMainToMemorizeRecV();
                Navigation.findNavController(v).navigate(mem_action);
                break;
            case R.id.cTxt_nine:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter9.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_ten:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter10.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_11:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter11.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_12:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter12.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_13:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter13.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_14:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter14.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_15:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter15.html";
                fragmentTransaction(v, url_string);
                break;
            case R.id.cTxt_16:
                interstitialAd.showInterstitial();
                url_string = "file:///android_asset/Chapter16.html";
                fragmentTransaction(v, url_string);
                break;
            default:
                Toast.makeText(getContext(), "error in OptionMain", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * this method receives two param and liable to transaction this to WebView class {@link WebView_Theory}
     * @param view require View object for Transaction one fragment to fragment/activity
     * @param getUrl receives URL to show HTML file from Asset folder
     */
    private static void fragmentTransaction(View view, String getUrl){
        Bundle url = new Bundle();
        url.putString("url", getUrl);
        Navigation.findNavController(view).navigate(R.id.action_optionsMain_to_webView_Theory, url);
    }

}
