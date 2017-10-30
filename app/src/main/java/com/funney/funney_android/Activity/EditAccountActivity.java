package com.funney.funney_android.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.funney.funney_android.R;

public class EditAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);
        final EditText editID = (EditText) findViewById(R.id.editID);
        final EditText editAddress = (EditText) findViewById(R.id.editAddress);
        final EditText editBirth = (EditText) findViewById(R.id.editBirth);
        final EditText editPassword = (EditText) findViewById(R.id.editPassword);
        final EditText editPassword2 = (EditText) findViewById(R.id.editPassword2);
        final EditText editPhoneNumber = (EditText) findViewById(R.id.editPhoneNumber);


        Button enterButton = (Button)findViewById(R.id.edit_enter);
        enterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), ConfirmEditAccountActivity.class);
                intent.putExtra("id", editID.getText().toString());
                intent.putExtra("name", editAddress.getText().toString());
                intent.putExtra("birthday", editBirth.getText().toString());
                intent.putExtra("phone", editPhoneNumber.getText().toString());
                intent.putExtra("password", editPassword.getText().toString());
                intent.putExtra("password_confirm", editPassword2.getText().toString());
                startActivity(intent);
            }
        });
    }
}