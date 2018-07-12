package com.birjuvachhani.navigationcomponentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

public class AlbumsFragment extends android.support.v4.app.Fragment {

    public AlbumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_albums, container, false);
        Button btnRefresh = view.findViewById(R.id.btnRefresh);
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavOptions options = new NavOptions.Builder()
                        .setEnterAnim(R.anim.slide_in_right)
                        .setExitAnim(R.anim.slide_out_left)
                        .setPopEnterAnim(R.anim.slide_in_left)
                        .setPopExitAnim(R.anim.slide_out_right)
                        .build();
                AlbumsFragmentDirections.Action_navAlbumsFragment_to_refreshFragment action
                        = new AlbumsFragmentDirections.Action_navAlbumsFragment_to_refreshFragment();
                action.setBtn_color(getResources().getColor(android.R.color.holo_purple));
                Navigation.findNavController(view).navigate(action, options);
            }
        });
        return view;
    }


}
