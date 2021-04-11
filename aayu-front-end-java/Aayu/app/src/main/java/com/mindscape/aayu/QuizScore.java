package com.mindscape.aayu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizScore extends AppCompatActivity {

    Button backToMainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_score);

        TextView lblForResult = (TextView) findViewById(R.id.resultLbl);
        TextView lblForFinalScore = (TextView) findViewById(R.id.finalScoreLbl);
        //getByBtnId
        backToMainBtn = findViewById(R.id.backToMain);

        int quizScore = getIntent().getIntExtra("CORRECT_ANSWS", 0);


        //setting up final score
        SharedPreferences totalMrks = getSharedPreferences("quiz", Context.MODE_PRIVATE);
        int finalScoreObtained = totalMrks.getInt("finalScore", 0);

        lblForResult.setText(quizScore + " / 10");
        lblForFinalScore.setText("Final Score: " + quizScore*10);
        finalScoreObtained += quizScore;

        //adding up the final score
        SharedPreferences.Editor editor = totalMrks.edit();
        editor.putInt("finalScore", finalScoreObtained);
        editor.commit();

        //set intent from main to scan
        backToMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });


    }
}