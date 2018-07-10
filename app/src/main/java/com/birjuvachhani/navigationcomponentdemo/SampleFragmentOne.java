package com.birjuvachhani.navigationcomponentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

public class SampleFragmentOne extends android.support.v4.app.Fragment {

    public SampleFragmentOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample_one, container, false);
        Button btnSecondSample = view.findViewById(R.id.btnSecondSample);
        btnSecondSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavOptions options = new NavOptions.Builder()
                        .setEnterAnim(R.anim.slide_in_right)
                        .setExitAnim(R.anim.slide_out_left)
                        .setPopEnterAnim(R.anim.slide_in_left)
                        .setPopExitAnim(R.anim.slide_out_right)
                        .build();
                Navigation.findNavController(view).navigate(R.id.sampleFragmentTwo, null, options);
            }
        });
        return view;
    }
}
