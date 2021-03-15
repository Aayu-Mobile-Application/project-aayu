package com.mindscape.aayu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mainMenuScan, mainMenuMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainMenuScan = (Button) findViewById(R.id.mainmenu_scan);
        mainMenuMap = (Button) findViewById(R.id.mainmenu_map);

        mainMenuMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mainMenuScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScanResultScreen();
            }
        });

    }

    public void openScanResultScreen() {

        Intent intent = new Intent(this, CameraScan.class);
        startActivity(intent);


    }

}