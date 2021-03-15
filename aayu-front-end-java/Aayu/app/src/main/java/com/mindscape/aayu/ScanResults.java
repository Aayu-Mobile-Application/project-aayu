package com.mindscape.aayu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class ScanResults extends AppCompatActivity {
    private Bitmap scannedImage;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_results);
        scannedImage = getIntent().getParcelableExtra("scannedImage");
        imageView = (ImageView) findViewById(R.id.scanned_imageView);

        if (scannedImage != null) {
            imageView.setImageBitmap(scannedImage);
        }


    }

}