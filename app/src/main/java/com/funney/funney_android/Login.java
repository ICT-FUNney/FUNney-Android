package com.funney.funney_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login
        );

        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent homeIntent = new Intent(getApplication(), HomeActivity.class);
                startActivity(homeIntent);
            }
        });

        Button newACButton = (Button) findViewById(R.id.newAccount);
        newACButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent newACIntent = new Intent(getApplication(), NewAccountActivity.class);
                startActivity(newACIntent);
            }
        });

        setTitle("FUNney");
    }
}

