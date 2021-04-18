package com.mindscape.aayu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AppQuiz extends AppCompatActivity {

    //declaring elements

    //label for question Number count
    private TextView cntLbl;
    //label for display questions
    private TextView quizLbl;
    //answer buttons
    private Button btnAnswer1;
    //answer buttons
    private Button btnAnswer2;
    //answer buttons
    private Button btnAnswer3;
    //answer buttons
    private Button btnAnswer4;
    //available question count
    private static final  int questionCount = 10;

    private String correctAnswer;
    //correct answer count
    private int correctAnswerCount = 0;
    //question count
    private int countQuestion = 1;
    //quiz score count
    private int quizScore = 0;

    //declaring an arrayList for questions
    ArrayList<ArrayList<String>> questionArray = new ArrayList<>();

    String dataForQuiz[][] = {
        //{"Question",rightAnswer","answer1","answer2","answer3"}
            {"What is the scientific name of Jew Plum which is locally known as Ambarella ?","Spondias dulcis","Abroma augusta","Uraria picta","Nypa fruiticans"},
            {"Which plant is known to be the Mother of Medicine ?","Holy basil","Basil","Arjun","Jatropa"},
            {"Out of below, Which part of Aralu plant is used for treatments ?","Pericap of fruit","Barks","Roots","Flowers"},
            {"For which type of treatments, Asamodagam is not used for ?","Headache","Asthma","Hiccough","Dysentery"},
            {"Which parts of the plant Gas Nivithi (local name) is used for treatments ?","Roots","Flowers","Stem","Fruit"},
            {"What is the local name of Zingiber officinale ? ","Inguru","Kaha","Koththamalli","Helamba"},
            {"What is the edible part in the plant, Welmee ?","Root","Stem","Fruit","Flowers"},
            {"Which is not a treatment type where Sesame seeds are not used for?","Headache","Burns","Wounds","Cystitis"},
            {"Which is a edible plant in the china rose plant ?","Flowers","Stem","Bark","Roots"},
            {"What is the local name of Munronia pinnata ?","Bin kohomba","Belipatta","Akkapana","Bimpol"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_quiz);

        //question count label
        cntLbl = (TextView)findViewById(R.id.cntLbl);
        //question load label
        quizLbl = (TextView)findViewById(R.id.resultLbl);
        //Answer selection button 1
        btnAnswer1 = (Button)findViewById(R.id.anwBtn1);
        //Answer selection button 2
        btnAnswer2 = (Button)findViewById(R.id.anwBtn2);
        //Answer selection button 3
        btnAnswer3 = (Button)findViewById(R.id.anwBtn3);
        //Answer selection button 4
        btnAnswer4 = (Button)findViewById(R.id.anwBtn4);

        //accessing quizArray from data for questions
        for(int i = 0; i < dataForQuiz.length; i++){

            //arrange an array
            ArrayList<String> tempryArryForQuiz = new ArrayList<>();
            tempryArryForQuiz.add(dataForQuiz[i][0]); //question
            tempryArryForQuiz.add(dataForQuiz[i][1]); // correct answer
            tempryArryForQuiz.add(dataForQuiz[i][2]); //answer1
            tempryArryForQuiz.add(dataForQuiz[i][3]); //answer2
            tempryArryForQuiz.add(dataForQuiz[i][4]); //answer3

            //merge temporary array to array with question array
            questionArray.add(tempryArryForQuiz);
        }
        loadTheNextQuestion();
    }

    public void loadTheNextQuestion(){

        //adding up the question count view
         cntLbl.setText("Question " + countQuestion);

         //randomizing for the size of array
        Random randomInt  = new Random();
        int numberRandom = randomInt.nextInt(questionArray.size());

        //accessing randomize questions
        ArrayList<String> question = questionArray.get(numberRandom);

        //setting up the question to the view (//{"rightAnswer","answer1","answer2","answer3"})
        //update question count, correct answer count
        quizLbl.setText(question.get(0));

        correctAnswer = question.get(1);

        //randomizing answers, without questions
        question.remove(0);
        //shuffle the answer set available
        Collections.shuffle(question);

        //setting up answers
        //answer1
        btnAnswer1.setText(question.get(0));
        //answer2
        btnAnswer2.setText(question.get(1));
        //answer3
        btnAnswer3.setText(question.get(2));
        //answer4
        btnAnswer4.setText(question.get(3));

        //unaccessing from main array
        questionArray.remove(numberRandom);
    }

    public void correctAnswerCheck(View v){
        //accessing user input button(the clicked button)
        Button clickedAnswerBtn = (Button) findViewById(v.getId());
        String textClickedBtn = clickedAnswerBtn.getText().toString();

        String alertEffect;

         if (textClickedBtn.equals(correctAnswer)){
             alertEffect = "Answer is Correct";
             correctAnswerCount++;
             //quizScore++;
             //countQuestion++;
         } else {
             alertEffect = "Answer is Wrong";
             //countQuestion++;
         }

         //displaying the alert box
         AlertDialog.Builder buildAlertDialog = new AlertDialog.Builder(this);
         buildAlertDialog.setTitle(alertEffect);
         buildAlertDialog.setMessage("Correct Answer : " + correctAnswer);
         buildAlertDialog.setPositiveButton("Got It", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 if (countQuestion == questionCount){
                     //display number of correct answers and score in second activity
                     Intent intentQuiz = new Intent(getApplicationContext(),QuizScore.class);
                     intentQuiz.putExtra("CORRECT_ANSWS", correctAnswerCount);
                     startActivity(intentQuiz);
                 }else{
                     countQuestion++;
                     loadTheNextQuestion();
                 }
             }
         });
         buildAlertDialog.setCancelable(false);
         buildAlertDialog.show();
    }
}