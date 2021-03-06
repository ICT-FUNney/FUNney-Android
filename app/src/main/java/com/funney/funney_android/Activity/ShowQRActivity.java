package com.funney.funney_android.Activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.funney.funney_android.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@TargetApi(21)
public class ShowQRActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_qr);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button searchButton = (Button) findViewById(R.id.button);
        View v = getWindow().getDecorView();
        getWindow().setStatusBarColor(Color.parseColor("#F3A033"));

        setSupportActionBar(toolbar);
        setTitle("QR");
        toolbar.setNavigationIcon(R.drawable.arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), PayActivity.class);
                startActivity(intent);
            }
        });


        onClickQRCodeCreate(v);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), ScanQRActivity.class);
                startActivity(intent);
            }
        });
    }

    //QRCode作成
    public void onClickQRCodeCreate(View view) {
        // QRCodeの作成
        Bitmap qrCodeBitmap = this.createQRCode("ICT-FUNNEY");

        // QRCodeの作成に成功した場合
        if (qrCodeBitmap != null) {
            // 結果をImageViewに表示
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageBitmap(qrCodeBitmap);
        }
    }

    private Bitmap createQRCode(String contents) {
        Bitmap qrBitmap = null;
        try {
            // QRコードの生成
            QRCodeWriter qrcodewriter = new QRCodeWriter();
            BitMatrix qrBitMatrix = qrcodewriter.encode(contents,
                    BarcodeFormat.QR_CODE,
                    900,
                    900);

            qrBitmap = Bitmap.createBitmap(900, 900, Bitmap.Config.ARGB_8888);
            qrBitmap.setPixels(this.createDot(qrBitMatrix), 0, 900, 0, 0, 900, 900);
        } catch (Exception ex) {
            // エンコード失敗
            Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
        return qrBitmap;
    }

    // ドット単位の判定
    private int[] createDot(BitMatrix qrBitMatrix) {
        // 縦幅・横幅の取得
        int width = qrBitMatrix.getWidth();
        int height = qrBitMatrix.getHeight();
        // 枠の生成
        int[] pixels = new int[width * height];

        // データが存在するところを黒にする
        for (int y = 0; y < height; y++) {
            // ループ回数盤目のOffsetの取得
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                // データが存在する場合
                if (qrBitMatrix.get(x, y)) {
                    pixels[offset + x] = Color.BLACK;
                } else {
                    pixels[offset + x] = Color.WHITE;
                }
            }
        }
        // 結果を返す
        return pixels;
    }
}
