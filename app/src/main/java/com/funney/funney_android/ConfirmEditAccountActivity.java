package com.funney.funney_android;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
        TextView id = (TextView) findViewById(R.id.edit_id);
        TextView name = (TextView) findViewById(R.id.edit_name);
        TextView birthday = (TextView) findViewById(R.id.edit_birthday);
        TextView phone = (TextView) findViewById(R.id.edit_phone);
        TextView password = (TextView) findViewById(R.id.edit_password);
        TextView passwordConfirm = (TextView) findViewById(R.id.edit_password_confirm);


        confirmDialog.setMessage("アカウント情報を変更しました");
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
                confirmDialog.show();
            }
        });

        setSupportActionBar(toolbar);
        setTitle("アカウント情報変更");
        toolbar.setNavigationIcon(R.drawable.arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // FIXME EditAccountの名前が変更された場合治す
                Intent intent = new Intent(getApplication(),EditAccount.class);
                startActivity(intent);
            }
        });
    }
}
