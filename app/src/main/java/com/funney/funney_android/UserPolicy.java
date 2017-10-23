package com.funney.funney_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserPolicy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_policy);

        Button agreeButton = (Button)findViewById(R.id.agree);
        agreeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent HomeIntent = new Intent(getApplication(), ConfirmNewAccountActivity.class);
                startActivity(HomeIntent);
            }
        });

        setTitle("FUNney");
    }
}
