package com.funney.funney_android.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.funney.funney_android.R;

public class NewAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        final EditText newID = (EditText) findViewById(R.id.newID);
        final EditText newAddress = (EditText) findViewById(R.id.newAddress);
        final EditText newBirth = (EditText) findViewById(R.id.newBirth);
        final EditText newPassword = (EditText) findViewById(R.id.newPassword);
        final EditText newPassword2 = (EditText) findViewById(R.id.newPassword2);
        final EditText newPhoneNumber = (EditText) findViewById(R.id.newPhoneNumber);

        Button enterButton = (Button)findViewById(R.id.new_enter);
        enterButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplication(), ConfirmNewAccountActivity.class);
                intent.putExtra("id", newID.getText().toString());
                intent.putExtra("name", newAddress.getText().toString());
                intent.putExtra("birthday", newBirth.getText().toString());
                intent.putExtra("phone", newPhoneNumber.getText().toString());
                intent.putExtra("password", newPassword.getText().toString());
                intent.putExtra("password_confirm", newPassword2.getText().toString());
                startActivity(intent);
            }
        });

        setTitle("FUNney");
    }
}
