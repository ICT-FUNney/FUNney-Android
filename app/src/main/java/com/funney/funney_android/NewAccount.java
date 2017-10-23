package com.funney.funney_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        Button enterButton = (Button)findViewById(R.id.edit_enter);
        enterButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent policyIntent = new Intent(getApplication(), ConfirmNewAccountActivity.class);
                startActivity(policyIntent);
            }
        });

        setTitle("FUNney");
    }
}
