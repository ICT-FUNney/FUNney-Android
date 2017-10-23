package com.funney.funney_android;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmEditAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_edit_account);


        final AlertDialog.Builder confirmDialog = new AlertDialog.Builder(this, R.style.ConfirmDialogStyle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button confirmButton = (Button) findViewById(R.id.confirm_button);

        // TODO 前アクティビティからの値の受け取りと対応するTextViewへの値の挿入
        final TextView id = (TextView) findViewById(R.id.edit_id);
        final TextView name = (TextView) findViewById(R.id.edit_name);
        final TextView birthday = (TextView) findViewById(R.id.edit_birthday);
        final TextView phone = (TextView) findViewById(R.id.edit_phone);
        final TextView password = (TextView) findViewById(R.id.edit_password);
        final TextView passwordConfirm = (TextView) findViewById(R.id.edit_password_confirm);

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
                // FIXME 前アクティビティから受け取った値を保存するようにする
                SharedPreferences data = getSharedPreferences("account_data", MODE_PRIVATE);
                SharedPreferences.Editor editor = data.edit();
                editor.putString("id", id.getText().toString());
                editor.putString("name", name.getText().toString());
                editor.putString("birthday", birthday.getText().toString());
                editor.putString("phone", phone.getText().toString());
                editor.putString("password", password.getText().toString());
                editor.putString("password_confirm", passwordConfirm.getText().toString());
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
                // FIXME EditAccountの名前が変更された場合治す
                Intent intent = new Intent(getApplication(), EditAccount.class);
                startActivity(intent);
            }
        });
    }
}
