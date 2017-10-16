package com.funney.funney_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RequestPay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_pay);


        Button payQRButton = (Button)findViewById(R.id.payQR);
        payQRButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText amountText = (EditText)findViewById(R.id.editText8);
                String text = amountText.getText().toString();
                Intent payQRIntent = new Intent(getApplication(), ShowQRActivity.class);
                payQRIntent.putExtra("payRequest",text);
                startActivity(payQRIntent);
            }
        });

        setTitle("FUNney");
    }
}
