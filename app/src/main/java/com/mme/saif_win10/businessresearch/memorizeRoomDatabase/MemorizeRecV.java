package com.mme.saif_win10.businessresearch.memorizeRoomDatabase;


import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mme.saif_win10.businessresearch.Interstitial_ad;
import com.mme.saif_win10.businessresearch.Parameter;
import com.mme.saif_win10.businessresearch.R;

import java.util.Objects;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * this fragment is used for read from Firebase Database and puting in RecyclerView
 * A simple {@link Fragment} subclass.
 * @author Saiful Islam
 * @since 13 March 2020
 * @version 1.0
 */
public class MemorizeRecV extends Fragment {

    private RecyclerView mRecycler_Memorize;
    private DatabaseReference mDatabase;
    private Interstitial_ad interstitialAd;
    private ConnectivityManager connectivityManager;

    public MemorizeRecV() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_memorize_rec_v, container, false);

        callingAndLoading_interstitialAd();

        connectivityManager = (ConnectivityManager) Objects.requireNonNull(getActivity()).
                getSystemService(CONNECTIVITY_SERVICE);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("memorize");
        mDatabase.keepSynced(false);
        mRecycler_Memorize = rootView.findViewById(R.id.mRecycler_Memorize);
        mRecycler_Memorize.setHasFixedSize(true);
        mRecycler_Memorize.setLayoutManager(new LinearLayoutManager(getContext()));
        return rootView;
    }


    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Parameter, ParameterViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Parameter, ParameterViewHolder>
                        (Parameter.class, R.layout.recycler_view_for_mcq, ParameterViewHolder.class, mDatabase) {
                    @Override
                    protected void populateViewHolder(ParameterViewHolder viewHolder, Parameter model, int position) {
                        final String post_key = getRef(position).getKey();
                        viewHolder.setSource(model.getSource());
                        viewHolder.setTopic(model.getTopic());
                        viewHolder.setSum(model.getSum());
                        viewHolder.setTotal(model.getTotal());
                        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                moveToMemoriseClass(post_key);
                            }
                        });

                    }
                };
        mRecycler_Memorize.setAdapter(firebaseRecyclerAdapter);
    }

    /**
     * This method is used to move from this to {@link MemorizeVersion1}
     * @since 13 March 2020
     * @author Saiful Islam
     * @param post_key string value - it is required in the next class
     */
    private void moveToMemoriseClass(String post_key) {
        assert connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

            Intent intent = new Intent(getActivity(), MemorizeVersion1.class);
            intent.putExtra("key_name", post_key);
            intent.putExtra("childName", "memorize");
            Toast.makeText(getContext(), "Please make sure you turn off the rotation of your device",
                    Toast.LENGTH_LONG).show();
            startActivity(intent);
        }else {
            Snackbar.make(Objects.requireNonNull(getActivity()).
                            findViewById(R.id.drawer_layout), "No Network Connection...",
                    Snackbar.LENGTH_LONG).show();
        }
    }

    public static class ParameterViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public ParameterViewHolder(View itemView)
        {
            super(itemView);
            mView = itemView;
        }
        public void setSource(String source)
        {
            TextView post_source = mView.findViewById(R.id.mTxt_source);
            post_source.setText(source);
        }
        public void setTopic(String topic)
        {
            TextView post_topic = mView.findViewById(R.id.mTxt_topic);
            post_topic.setText(topic);
        }
        public void setSum(String sum)
        {
            TextView post_sum = mView.findViewById(R.id.mTxt_sum);
            post_sum.setText(sum);
        }
        public void setTotal(String total)
        {
            TextView post_total = mView.findViewById(R.id.mTxt_total);
            post_total.setText(total);
        }
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

    @Override
    public void onResume() {
        super.onResume();
        interstitialAd.showInterstitial();
    }
}
