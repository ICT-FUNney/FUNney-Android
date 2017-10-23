package com.funney.funney_android;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmEditAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_edit_account);


        final AlertDialog.Builder confirmDialog = new AlertDialog.Builder(this, R.style.ConfirmDialogStyle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button confirmButton = (Button) findViewById(R.id.confirm_button);

        Intent intent = getIntent();

        final TextView id = (TextView) findViewById(R.id.edit_id);
        final TextView name = (TextView) findViewById(R.id.edit_name);
        final TextView birthday = (TextView) findViewById(R.id.edit_birthday);
        final TextView phone = (TextView) findViewById(R.id.edit_phone);
        final TextView password = (TextView) findViewById(R.id.edit_password);
        final TextView passwordConfirm = (TextView) findViewById(R.id.edit_password_confirm);

        final String editID = intent.getStringExtra("id");
        final String editName = intent.getStringExtra("name");
        final String editBirthday = intent.getStringExtra("birthday");
        final String editPhone = intent.getStringExtra("phone");
        final String editPassword = intent.getStringExtra("password");
        final String editPasswordConfirm = intent.getStringExtra("password_confirm");

        id.setText(editID);
        name.setText(editName);
        birthday.setText(editBirthday);
        phone.setText(editPhone);
        password.setText(editPassword);
        passwordConfirm.setText(editPasswordConfirm);


        confirmDialog.setMessage("アカウント情報を変更しました");
        confirmDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            /**
             * ダイアログのOKタップ時
             */
            public void onClick(DialogInterface dialog, int id) {
                /**
                 * ダイアログのOKボタンタップ時
                 */
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
                editor.putString("id", editID);
                editor.putString("name", editName);
                editor.putString("birthday", editBirthday);
                editor.putString("phone", editPhone);
                editor.putString("password", editPassword);
                editor.putString("password_confirm", editPasswordConfirm);
                editor.apply();
                confirmDialog.show();
            }
        });

        setSupportActionBar(toolbar);
        setTitle("アカウント情報変更");
        toolbar.setNavigationIcon(R.drawable.arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            /**
             * ツールバーの戻るボタン
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), EditAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}
