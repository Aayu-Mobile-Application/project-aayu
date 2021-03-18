package com.mindscape.aayu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ScanResults extends AppCompatActivity {

    private Bitmap scannedImage;
    private ImageView imageView;
    static TextView description, treatments, familyName, localName, plantStatus, similarPlants, scientificName;
    static ProgressBar spinner;
    static int leafType;
    static int languageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_results);
        scannedImage = getIntent().getParcelableExtra("scannedImage");
        languageId = getIntent().getIntExtra("langId", 2);
        leafType = getIntent().getIntExtra("leafType", 0);
        imageView = (ImageView) findViewById(R.id.scanned_imageView);
        treatments = (TextView) findViewById(R.id.scan_treatments);
        familyName = (TextView) findViewById(R.id.scan_familyname);
        localName = (TextView) findViewById(R.id.scan_localname);
        scientificName = (TextView) findViewById(R.id.scan_scieName);
        plantStatus = (TextView) findViewById(R.id.scan_status);
        similarPlants = (TextView) findViewById(R.id.scan_similar);
        description = (TextView) findViewById(R.id.scan_plantDescription);
        spinner = (ProgressBar) findViewById(R.id.progressBar1);

        spinner.setVisibility(View.GONE);
        if (scannedImage != null) {

            imageView.setImageBitmap(scannedImage);
            if (leafType == 1) {
                AlexNet();
            } else if (leafType == 2) {
                ResNet();
            }
        }


    }

    public void AlexNet() {
        handlerExecution(1);
    }

    public void ResNet() {
        handlerExecution(3);

    }

    public void handlerExecution(int plantIdNo) {
        ScanResultHandler scanResultHandler = new ScanResultHandler();
        ScanResultHandler.plantId = plantIdNo;
        ScanResultHandler.handler_languageId = languageId;
        scanResultHandler.execute();

    }
}