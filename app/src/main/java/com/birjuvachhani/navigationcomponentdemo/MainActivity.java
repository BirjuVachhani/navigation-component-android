package com.birjuvachhani.navigationcomponentdemo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private NavigationView nvMain;
    private DrawerLayout mDrawerLayout;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolBar = findViewById(R.id.toolBar);
        nvMain = findViewById(R.id.nvMain);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        navController = Navigation.findNavController(this, R.id.mainNavHostFrag);
        setSupportActionBar(mToolBar);
        setDrawer();
        NavigationUI.setupWithNavController(nvMain, navController);
        NavigationUI.setupActionBarWithNavController(this, navController, mDrawerLayout);
    }

    private void setDrawer() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.open, R.string.close);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
