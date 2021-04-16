package com.mindscape.aayu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //private Button mainMenuScan, mainMenuMap;

    //scan button
     ImageView scnBtn;
    //map btn
     ImageView mapBtn;
    //quiz btn
     ImageView quizBtn;
     TextView name;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getByBtnId
        scnBtn = findViewById(R.id.scan);
        //getByBtnId
        mapBtn = findViewById(R.id.map);
        //getByBtnId
        quizBtn = findViewById(R.id.quizbtn);
        name=findViewById(R.id.main_txtUname);

        name.setText("Hello "+Global.loggedName);
        //set intent from main to scan
        scnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LeafType.class);
                startActivity(i);
            }
        });
        //set intent from main to map
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapScreen.class);
                startActivity(i);
            }
        });

        //set intent from main to quiz
        quizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AppQuiz.class);
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