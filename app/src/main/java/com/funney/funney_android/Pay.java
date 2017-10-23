package com.funney.funney_android;

import android.content.Intent;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pay extends AppCompatActivity {

    private TextView textView;
    private DialogFragment dialogFragment;
    private FragmentManager flagmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        textView = (TextView) findViewById(R.id.alert_view);

        Button requestButton = (Button) findViewById(R.id.request);
        requestButton.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                Intent requestIntent = new Intent(getApplication(), RequestPay.class);
                startActivity(requestIntent);
            }
        });

        Button sendButton = (Button) findViewById(R.id.send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //ここでQRカメラ起動
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flagmentManager = getSupportFragmentManager();

                // DialogFragment を継承したAlertDialogFragmentのインスタンス
                dialogFragment = new AlertDialogFragment();
                // DialogFragmentの表示
                dialogFragment.show(flagmentManager, "how would you like to send money?");
            }
        });
    }

    public void setTextView(String message) {
        textView.setText(message);
    }

    // DialogFragment を継承したクラス
    public static class AlertDialogFragment extends DialogFragment {
        // 選択肢のリスト
        private String[] menulist = {"Scan a QR Code", "Send to email or contact", "キャンセル"};

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

            // タイトル
            alert.setTitle("Test AlertDialog");
            alert.setItems(menulist, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int idx) {
                    // 選択１
                    if (idx == 0) {
                        setMassage(menulist[0]);
                    }
                    // 選択２
                    else if (idx == 1) {
                        setMassage(menulist[1]);
                    }
                    // 選択３
                    else if (idx == 2) {
                        setMassage(menulist[2]);
                    }
                    // cancel"
                    else {
                        // nothing to do
                    }
                }
            });

            return alert.create();
        }

        private void setMassage(String message) {
            Pay pay = (Pay) getActivity();
            pay.setTextView(message);
        }

    }

    //setTitle("FUNney");
}
