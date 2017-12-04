package com.funney.funney_android.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.funney.funney_android.R;

public class RequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        // 5.0以上でのToolbarの影消し
        actionbar.setElevation(0f);
        setTitle("Request Money");

        // スキャン画面に遷移
        //          ↓SCAN A QR CODEボタンと関連付ける変数
        Button ScanButton = (Button) findViewById(R.id.Scan);
        ScanButton.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                Intent requestIntent = new Intent(getApplication(), ScanQRActivity.class);
                startActivity(requestIntent);
            }
        });

        // QR画面に遷移
        //           ↓▼REQUESTと関連付ける変数
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
