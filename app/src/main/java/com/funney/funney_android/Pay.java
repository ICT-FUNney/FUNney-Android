package com.funney.funney_android;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Pay extends AppCompatActivity {


    private DialogFragment dialogFragment;
    private FragmentManager flagmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);


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

            //アラートの起動
            @Override
            public void onClick(View v) {
                flagmentManager = getSupportFragmentManager();

                // DialogFragment を継承したAlertDialogFragmentのインスタンス
                dialogFragment = new AlertDialogFragment();
                // DialogFragmentの表示
                dialogFragment.show(flagmentManager, "alert dialog");
            }
        });
    }


    // DialogFragment を継承したクラス
    public static class AlertDialogFragment extends DialogFragment {
        // アラートの選択肢のリスト
        private String[] menulist = {"Scan a QR Code", "Send to email or contact","cancel"};

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

            alert.setTitle("How would you like to send money?");
            alert.setItems(menulist, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int idx) {

                    // アラートの選択肢
                    //if (idx == 0) {
                        //アラートを押したら画面遷移
                       Intent sendIntent = new Intent(getActivity().getApplication(), ShowQR.class);
                        startActivity(sendIntent);
                    //}
                   // else if (idx == 1) {
                        //Intent scanqrIntent = new Intent(getApplication(), ShowQR.class);
                        //startActivity(scanqrIntent);
                   // }
                    //else {
                        // nothing to do
                    //}
                }
            });

            return alert.create();
        }


    }

    //setTitle("FUNney");
}
