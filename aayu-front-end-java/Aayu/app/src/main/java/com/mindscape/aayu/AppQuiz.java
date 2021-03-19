package com.mindscape.aayu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class AppQuiz extends AppCompatActivity {

    //declaring elements
    //quizNumber
    private TextView cntLbl;
    //questions
    private TextView quizLbl;
    //answer buttons
    private Button btnAnswer1;
    private Button btnAnswer2;
    private Button btnAnswer3;
    private Button btnAnswer4;
    static final private int questionCount = 10;

    private String correctAnswer;
    private int correctAnswerCount = 0;
    private int countQuestion = 1;

    //initializing arrayList
    ArrayList<ArrayList<String>> questionArray = new ArrayList<>();

    String dataForQuiz[][] = {
        //{"Question",rightAnswer","answer1","answer2","answer3"}
            {"question1","Mango","Orange","Arjun","Jatropa"},
            {"question2","Orange","Orange","Arjun","Jatropa"},
            {"question3","Arjun","Jatropa","Mango","Jatropa"},
            {"question4","Arjun","Orange","Jatropa","Mango"},
            {"question5","Arjun","Orange","Jatropa","Mango"},
            {"question6","Arjun","Orange","Jatropa","Mango"},
            {"question7","Arjun","Orange","Jatropa","Mango"},
            {"question8","Arjun","Orange","Jatropa","Mango"},
            {"question9","Arjun","Orange","Jatropa","Mango"},
            {"question10","Arjun","Orange","Jatropa","Mango"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_quiz);

        cntLbl = (TextView)findViewById(R.id.cntLbl);
        quizLbl = (TextView)findViewById(R.id.quizLbl);
        btnAnswer1 = (Button)findViewById(R.id.anwBtn1);
        btnAnswer2 = (Button)findViewById(R.id.anwBtn2);
        btnAnswer3 = (Button)findViewById(R.id.anwBtn3);
        btnAnswer4 = (Button)findViewById(R.id.anwBtn4);

        //accessing quizArray from quizdata
        for(int i = 0; i < dataForQuiz.length; i++){

            //arrange array
            ArrayList<String> tempryArry = new ArrayList<>();
            tempryArry.add(dataForQuiz[i][0]); //question
            tempryArry.add(dataForQuiz[i][1]); // correct answer
            tempryArry.add(dataForQuiz[i][2]); //answer1
            tempryArry.add(dataForQuiz[i][3]); //answer2
            tempryArry.add(dataForQuiz[i][4]); //answer3

            //merge temporary array to array with question array
            questionArray.add(tempryArry);
        }
        loadTheNextQuestion();
    }

    public void loadTheNextQuestion(){

        //adding up the question view
         cntLbl.setText("Question" + countQuestion);

         //randomizing for the size of array
        Random random  = new Random();
        int numberRandom = random.nextInt(questionArray.size());

        //accessing randomize question
        ArrayList<String> question = questionArray.get(numberRandom);

        //setting up the question to the view (//{"rightAnswer","answer1","answer2","answer3"})
        quizLbl.setText(question.get(0));
        correctAnswer = question.get(1);

        //randomizing answers, without questions
        question.remove(0);
        Collections.shuffle(question);

        //setting up answers
        btnAnswer1.setText(question.get(0));
        btnAnswer2.setText(question.get(1));
        btnAnswer3.setText(question.get(2));
        btnAnswer4.setText(question.get(3));

        //unaccessing from main array
        questionArray.remove(numberRandom);
    }

    public void correctAnswerCheck(View v){
        //accessing user input button
        Button clickedAnswerBtn = (Button) findViewById(v.getId());
        String textClickedBtn = clickedAnswerBtn.getText().toString();

        String alertEffect;
         if (textClickedBtn.equals(correctAnswer)){
             alertEffect = "Correct";
             correctAnswerCount++;
             countQuestion++;
         } else {
             alertEffect = "Wrong";
             countQuestion++;
         }

         //alert box
        AlertDialog.Builder buildAlertDialog = new AlertDialog.Builder(this);
         buildAlertDialog.setTitle(alertEffect);
         buildAlertDialog.setMessage("Correct Answer : " + correctAnswer);
         buildAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 if (correctAnswerCount == questionCount){

                 }else{
                     correctAnswerCount++;
                     loadTheNextQuestion();
                 }
             }
         });
         buildAlertDialog.setCancelable(false);
         buildAlertDialog.show();
    }
}