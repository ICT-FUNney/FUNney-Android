package com.funney.funney_android.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.funney.funney_android.Adapter.HomeViewPagerAdapter;
import com.funney.funney_android.Question;
import com.funney.funney_android.R;
import com.funney.funney_android.UserPolicy;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager pager;
    private int currentPage;
    private String orrange = "#F3A033";
    private String white = "#FFFFFF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        // ViewPager関連
        pager = (ViewPager) findViewById(R.id.home_pager);
        FragmentPagerAdapter adapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        currentPage = 1;

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                int pg = pager.getCurrentItem();
                if (pg == 0) {
                    //注目の取引ボタンをオレンジにする
                    Button featuredButton = (Button) findViewById(R.id.featured_transaction_button);
                    featuredButton.setBackgroundResource(R.drawable.featured_button);
                    featuredButton.setTextColor(Color.parseColor(white));

                    //取引履歴ボタンを白くする
                    Button historyButton = (Button) findViewById(R.id.transaction_history_button);
                    historyButton.setBackgroundResource(R.drawable.history_button_white);
                    historyButton.setTextColor(Color.parseColor(orrange));
                } else {
                    //取引履歴ボタンをオレンジにする
                    Button historyButton = (Button) findViewById(R.id.transaction_history_button);
                    historyButton.setBackgroundResource(R.drawable.history_button);
                    historyButton.setTextColor(Color.parseColor(white));

                    //注目の取引ボタンを白くする
                    Button featuredButton = (Button) findViewById(R.id.featured_transaction_button);
                    featuredButton.setBackgroundResource(R.drawable.featured_button_white);
                    featuredButton.setTextColor(Color.parseColor(orrange));
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        // PayButton関連
        Button payButton = (Button) findViewById(R.id.pay_button);

        payButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent payIntent = new Intent(getApplication(), PayActivity.class);

                startActivity(payIntent);
            }
        });


        // NavigationDrawer関連
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // navigationDrawerのheaderにローカルに保存してあるユーザー名を表示
        View header = navigationView.getHeaderView(0);
        TextView userName = (TextView) header.findViewById(R.id.username_header);
        SharedPreferences pref = getSharedPreferences("account_data", MODE_PRIVATE);
        userName.setText(pref.getString("name", ""));

    }

    public void onClickHistory(View view) {
        currentPage = 1;
        pager.setCurrentItem(currentPage);
    }

    public void onClickFeatured(View view) {
        currentPage = 0;
        pager.setCurrentItem(currentPage);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_mining) {
            // Handle the camera action
        } else if (id == R.id.nav_edit_account) {
            Intent intent = new Intent(getApplication(), EditAccountActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_agreement) {
            Intent intent = new Intent(getApplication(), UserPolicy.class);
            startActivity(intent);
        } else if (id == R.id.nav_question) {
            Intent intent = new Intent(getApplication(), Question.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout) {
            Intent intent = new Intent(getApplication(), LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
