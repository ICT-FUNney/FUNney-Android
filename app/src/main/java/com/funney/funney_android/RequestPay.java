package com.funney.funney_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RequestPay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_pay);

        Button payQRButton = (Button)findViewById(R.id.payQR);
        payQRButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent payQRIntent = new Intent(getApplication(), ShowQR.class);
                startActivity(payQRIntent);
            }
        });

        setTitle("FUNney");
    }
}
