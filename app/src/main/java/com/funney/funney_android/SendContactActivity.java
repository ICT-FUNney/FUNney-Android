package com.funney.funney_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SendContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_contact);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        // 5.0以上でのToolbarの影消し
        actionbar.setElevation(0f);
        setTitle("Send Money");
    }
}
