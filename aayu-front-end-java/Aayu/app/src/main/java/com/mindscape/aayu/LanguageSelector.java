package com.mindscape.aayu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LanguageSelector extends AppCompatActivity {

    private Button english, sinhala, tamil;
    private int leafType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selector);
        english = (Button) findViewById(R.id.language_english);
        sinhala = (Button) findViewById(R.id.language_sinhala);
        tamil = (Button) findViewById(R.id.language_tamil);

        leafType=getIntent().getIntExtra("leafType",0);
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lang_languageId = 1;
                openScanResultsScreen(lang_languageId);


            }
        });
        sinhala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lang_languageId = 2;
                openScanResultsScreen(lang_languageId);

            }
        });
        tamil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lang_languageId = 3;
                openScanResultsScreen(lang_languageId);
            }
        });


    }

    public void openScanResultsScreen(int lang_languageId) {
        Intent intent = new Intent(this, ScanResults.class);
        Global.langId=lang_languageId;
        startActivity(intent);

    }
}