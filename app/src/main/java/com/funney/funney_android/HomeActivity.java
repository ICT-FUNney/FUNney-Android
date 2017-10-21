package com.funney.funney_android;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class HomeActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fragmentManager = getSupportFragmentManager();
        getSupportActionBar().setElevation(0);
        onClickFeatured(getWindow().getDecorView().findViewById(android.R.id.content));
    }

    public void onClickHistory(View view) {

        Fragment fragment = new TransactionHistoryFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.contents, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void onClickFeatured(View view) {
        Fragment fragment = new FeaturedTransactionFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.contents, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
