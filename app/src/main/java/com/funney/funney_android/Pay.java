package com.funney.funney_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        Button sendButton = (Button)findViewById(R.id.send);
        sendButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent popupIntent = new Intent(getApplication(), Popup.class);
                startActivity(new Intent(popupIntent));

                //ここでQRカメラ起動
            }
        });

        Button requestButton = (Button)findViewById(R.id.request);
        requestButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent requestIntent = new Intent(getApplication(), RequestPay.class);
                startActivity(requestIntent);
            }
        });

        setTitle("FUNney");
    }
}
