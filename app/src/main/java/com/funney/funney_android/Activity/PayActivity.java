package com.funney.funney_android.Activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.funney.funney_android.Question;
import com.funney.funney_android.R;
import com.funney.funney_android.UserPolicy;

public class PayActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DialogFragment dialogFragment;
    private FragmentManager flagmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);


        Button requestButton = (Button) findViewById(R.id.request);
        requestButton.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                Intent requestIntent = new Intent(getApplication(), RequestActivity.class);
                startActivity(requestIntent);
            }
        });

        Button sendButton = (Button) findViewById(R.id.send);
        sendButton.setOnClickListener(new View.OnClickListener() {

            //アラートの起動
            @Override
            public void onClick(View v) {
                flagmentManager = getSupportFragmentManager();

                // DialogFragment を継承したAlertDialogFragmentのインスタンス
                dialogFragment = new AlertDialogFragment();
                // DialogFragmentの表示
                dialogFragment.show(flagmentManager, "alert dialog");
            }
        });

        // NavigationDrawer関連

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_pay);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_pay);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.pay_view);
        navigationView.setNavigationItemSelectedListener(this);

        // navigationDrawerのheaderにローカルに保存してあるユーザー名を表示
        View header = navigationView.getHeaderView(0);
        TextView userName = header.findViewById(R.id.username_header);
        SharedPreferences pref = getSharedPreferences("account_data", MODE_PRIVATE);
        userName.setText(pref.getString("name", ""));

    }


    // DialogFragment を継承したクラス
    public static class AlertDialogFragment extends DialogFragment {
        // アラートの選択肢のリスト
        private String[] menulist = {"Scan a QR Code", "Send to email or contact", "cancel"};

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

            //alert.setTitle("How would you like to send money?");
            alert.setItems(menulist, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int idx) {

                    // アラートの選択肢
                    if (idx == 0) {
                        //アラートを押したら画面遷移
                        Intent sendIntent = new Intent(getActivity().getApplication(), ShowQRActivity.class);
                        startActivity(sendIntent);
                        //}
                    } else {
                        Intent scanIntent = new Intent(getActivity().getApplication(), SendContactActivity.class);
                        startActivity(scanIntent);
                    }
                }
            });

            return alert.create();
        }
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_pay);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
