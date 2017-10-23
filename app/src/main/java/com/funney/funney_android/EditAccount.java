package com.funney.funney_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);

        Button enterButton = (Button)findViewById(R.id.edit_enter);
        enterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent confirmeditIntent = new Intent(getApplication(), ConfirmEditAccountActivity.class);
                startActivity(confirmeditIntent);
            }
        });
    }
}