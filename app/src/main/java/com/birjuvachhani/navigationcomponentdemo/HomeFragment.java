package com.birjuvachhani.navigationcomponentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;

public class HomeFragment extends android.support.v4.app.Fragment {

    private Button btnViewDemo;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnViewDemo = view.findViewById(R.id.btnViewDemo);
        btnViewDemo.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.navDemoFrag,null));
        return view;
    }
}
