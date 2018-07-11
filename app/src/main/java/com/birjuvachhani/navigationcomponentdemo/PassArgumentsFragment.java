package com.birjuvachhani.navigationcomponentdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.navigation.Navigation;

public class PassArgumentsFragment extends android.support.v4.app.Fragment {

    private EditText etName;
    private FloatingActionButton fabNext;

    public PassArgumentsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pass_arguments, container, false);
        etName = view.findViewById(R.id.etName);
        fabNext = view.findViewById(R.id.fabNext);
        etName.requestFocus();
        etName.setActivated(true);
        etName.setPressed(true);

        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etName.getText().toString();
                if(TextUtils.isEmpty(name)) return;
                Bundle args = new Bundle();
                args.putString("name",name);
                Navigation.findNavController(view).navigate(R.id.);
            }
        });
        return view;
    }
}
