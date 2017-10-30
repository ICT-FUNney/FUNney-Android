package com.funney.funney_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.funney.funney_android.Activity.EditAccountActivity;
import com.funney.funney_android.Activity.LoginActivity;

public class HelpOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_option);

        //よくある質問
        Button questionButton = (Button)findViewById(R.id.question);
        questionButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent questionIntent = new Intent(getApplication(), Question.class);
                startActivity(questionIntent);
            }
        });

        //利用規約
        Button userPolicyButton = (Button)findViewById(R.id.policyConfirm);
        userPolicyButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent userPolicyIntent = new Intent(getApplication(), UserPolicy.class);
                startActivity(userPolicyIntent);
            }
        });

        //アカウント情報変更
        Button editACButton = (Button)findViewById(R.id.editAC);
        editACButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent editACIntent = new Intent(getApplication(), EditAccountActivity.class);
                startActivity(editACIntent);
            }
        });

        //ログアウト
        Button logoutButton = (Button)findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent logoutIntent = new Intent(getApplication(), LoginActivity.class);
                startActivity(logoutIntent);
            }
        });

        setTitle("FUNney");
    }
}
