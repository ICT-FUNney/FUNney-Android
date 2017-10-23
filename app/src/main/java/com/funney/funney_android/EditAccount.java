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

        // FIXME 仮の遷移なのでちゃんとした実装がきたら消す
        Button button = (Button) findViewById(R.id.go_to_confirm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(),ConfirmEditAccountActivity.class);
                startActivity(intent);
            }
        });
    }

}
