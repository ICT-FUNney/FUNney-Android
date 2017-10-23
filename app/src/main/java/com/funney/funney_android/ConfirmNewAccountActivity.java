package com.funney.funney_android;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmNewAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_new_account);


        final AlertDialog.Builder confirmDialog = new AlertDialog.Builder(this, R.style.ConfirmDialogStyle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button confirmButton = (Button) findViewById(R.id.confirm_button);

        Intent intent = getIntent();

        final TextView id = (TextView) findViewById(R.id.new_id);
        final TextView name = (TextView) findViewById(R.id.new_name);
        final TextView birthday = (TextView) findViewById(R.id.new_birthday);
        final TextView phone = (TextView) findViewById(R.id.new_phone);
        final TextView password = (TextView) findViewById(R.id.new_password);
        final TextView passwordConfirm = (TextView) findViewById(R.id.new_password_confirm);

        final String newID = intent.getStringExtra("id");
        final String newName = intent.getStringExtra("name");
        final String newBirthday = intent.getStringExtra("birthday");
        final String newPhone = intent.getStringExtra("phone");
        final String newPassword = intent.getStringExtra("password");
        final String newPasswordConfirm = intent.getStringExtra("password_confirm");

        id.setText(newID);
        name.setText(newName);
        birthday.setText(newBirthday);
        phone.setText(newPassword);
        password.setText(newPassword);
        passwordConfirm.setText(newPasswordConfirm);

        confirmDialog.setMessage("アカウントを作成しました");
        confirmDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            /**
             * ダイアログのOKタップ時
             */
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getApplication(), HomeActivity.class);
                startActivity(intent);
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Confirmボタンタップ時
             */
            @Override
            public void onClick(View view) {
                SharedPreferences data = getSharedPreferences("account_data", MODE_PRIVATE);
                SharedPreferences.Editor editor = data.edit();
                editor.putString("id", newID);
                editor.putString("name", newName);
                editor.putString("birthday", newBirthday);
                editor.putString("phone", newPhone);
                editor.putString("password", newPassword);
                editor.putString("password_confirm", newPasswordConfirm);
                editor.apply();
                confirmDialog.show();
            }
        });

        setSupportActionBar(toolbar);
        setTitle("アカウント作成");
        toolbar.setNavigationIcon(R.drawable.arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), NewAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}
