package com.funney.funney_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        // 5.0以上でのToolbarの影消し
        actionbar.setElevation(0f);
        setTitle("Request Money");

        Button ScanButton = (Button) findViewById(R.id.Scan);
        ScanButton.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                Intent requestIntent = new Intent(getApplication(), ScanQRActivity.class);
                startActivity(requestIntent);
            }
        });

        Button requestButton = (Button) findViewById(R.id.RequestButton);
        requestButton.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                Intent requestIntent = new Intent(getApplication(), ShowQRActivity.class);
                startActivity(requestIntent);
            }
        });
    }
}
