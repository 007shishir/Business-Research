package com.mme.saif_win10.businessresearch.mcqRoomDatabase;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;


import android.content.Intent;

import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.mme.saif_win10.businessresearch.Parameter;
import com.mme.saif_win10.businessresearch.R;
import com.mme.saif_win10.businessresearch.mcqRoomDatabase.McqVersion1;

import static android.content.Context.CONNECTIVITY_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class McqRecV extends Fragment {

    private RecyclerView mRecycler_Mcq;
    private DatabaseReference mDatabase;
    private View v;
    private ConnectivityManager connectivityManager;

    public McqRecV() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.activity_mcq_rec_v, container, false);
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("busResearch");
        connectivityManager = (ConnectivityManager) getActivity().getSystemService(CONNECTIVITY_SERVICE);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("busResearch");
        mDatabase.keepSynced(false);
        mRecycler_Mcq = v.findViewById(R.id.mRecycler_Mcq);
        mRecycler_Mcq.setHasFixedSize(true);
        mRecycler_Mcq.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
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
                                assert connectivityManager != null;
                                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                                if (networkInfo != null && networkInfo.isConnected()) {
                                    Intent intent = new Intent(getActivity(), McqVersion1.class);
                                    intent.putExtra("key_name", post_key);
                                    intent.putExtra("childName", "busResearch");
                                    Toast.makeText(getContext(), "Please make sure you turn off the rotation of your device", Toast.LENGTH_LONG).show();
                                    startActivity(intent);
                                } else {
                                    Snackbar.make(getActivity().findViewById(R.id.drawer_layout), "No Network Connection...", Snackbar.LENGTH_LONG).show();
                                }
                            }
                        });

                    }
                };
        mRecycler_Mcq.setAdapter(firebaseRecyclerAdapter);
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
}