package com.funney.funney_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button showQRButton = (Button)findViewById(R.id.showQR);
        showQRButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent showQRIntent = new Intent(getApplication(), ShowQR.class);
                startActivity(showQRIntent);
            }
        });

        Button payButton = (Button)findViewById(R.id.pay);
        payButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent payIntent = new Intent(getApplication(), Pay.class);
                startActivity(payIntent);
            }
        });

        Button helpButton = (Button)findViewById(R.id.help);
        helpButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent helpIntent = new Intent(getApplication(), HelpOption.class);
                startActivity(helpIntent);
            }
        });


        setTitle("FUNney");
    }
}
