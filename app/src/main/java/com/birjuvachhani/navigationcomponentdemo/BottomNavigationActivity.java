package com.birjuvachhani.navigationcomponentdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class BottomNavigationActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        navController = Navigation.findNavController(this, R.id.mainBottomNavFrag);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        navController.addOnNavigatedListener(new NavController.OnNavigatedListener() {
            @Override
            public void onNavigated(@NonNull NavController controller, @NonNull NavDestination destination) {
                switch (destination.getId()) {
                    case R.id.navAlbumsFragment:
                        bottomNavigationView.setItemBackgroundResource(android.R.color.holo_purple);
                        break;
                    case R.id.navArtistsFragment:
                        bottomNavigationView.setItemBackgroundResource(android.R.color.holo_red_light);
                        break;
                    case R.id.navSongsFragment:
                        bottomNavigationView.setItemBackgroundResource(android.R.color.holo_blue_dark);
                        break;
                }
            }
        });
    }
}
