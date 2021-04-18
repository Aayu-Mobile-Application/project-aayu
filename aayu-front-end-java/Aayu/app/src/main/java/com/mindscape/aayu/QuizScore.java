package com.mindscape.aayu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizScore extends AppCompatActivity {

    //declaring elements
    //back home button
    Button backToMainBtn;
    //play again button
    Button playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_score);

        //display number of correct answers
        TextView lblForResult = (TextView) findViewById(R.id.resultLbl);
        //display the final score
        TextView lblForFinalScore = (TextView) findViewById(R.id.finalScoreLbl);
        //get button by ID
        backToMainBtn = findViewById(R.id.backToMain);
        //get button by ID
        playAgain = findViewById(R.id.backToQuiz);

        //get intent from quiz activity
        int quizScore = getIntent().getIntExtra("CORRECT_ANSWS", 0);

        //display number of correct answers
        lblForResult.setText(quizScore + " / 10");
        //display final score
        lblForFinalScore.setText("Final Score: " + quizScore*10+" /100");

        //set intent from quiz to main
        //back to main activity
        backToMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        //set intent from score to quiz
        //back to quiz activity
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AppQuiz.class);
                startActivity(i);
            }
        });
    }
}