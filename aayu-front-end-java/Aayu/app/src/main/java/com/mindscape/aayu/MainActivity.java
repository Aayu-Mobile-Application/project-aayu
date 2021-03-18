package com.mindscape.aayu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button mainMenuScan, mainMenuMap;

    //scan button
    ImageView scnBtn;
    //map btn
    ImageView mapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getByBtnId
        scnBtn = findViewById(R.id.scan);
        //getByBtnId
        mapBtn = findViewById(R.id.map);

        //set intent from main to scan
        scnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LeafType.class);
                startActivity(i);
            }
        });
        //set intent from main to scan
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapScreen.class);
                startActivity(i);
            }
        });

        /*mainMenuScan = (Button) findViewById(R.id.mainmenu_scan);
        mainMenuMap = (Button) findViewById(R.id.mainmenu_map);*/

      /*  mainMenuMap.setOnClickListener(new View.OnClickListener() {
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
*/


    }

    public void openScanResultScreen() {

        Intent intent = new Intent(this, CameraScan.class);
        startActivity(intent);


    }

}