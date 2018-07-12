package com.birjuvachhani.navigationcomponentdemo;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;

public class RefreshFragment extends android.support.v4.app.Fragment {

    public RefreshFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_refresh, container, false);
        Button btnGoBack = view.findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });
        Bundle args = getArguments();
        if (args != null && args.containsKey("btn_color")) {
            int color = args.getInt("btn_color");
            btnGoBack.setBackgroundTintList(ColorStateList.valueOf(color));
        }
        return view;
    }
}
