//DISPLAYS a multiple choice question

package com.example.gardenofpuzzles;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MultipleChoicePuzzle extends AppCompatActivity {

    Button backButton, answerButton1, answerButton2, answerButton3, answerButton4;
    TextView puzzleDescription;
    MultipleChoiceQuestion quest;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //this just makes the app fullscreen, gets rid of the top menu bar
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.puzzle_multiple_choice);
        //get the question object from the intent
        Intent intent = getIntent();
        quest = intent.getParcelableExtra("QUESTION");
        //sets the background color
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.bkrdColor));

        //set the button and textview text to whatever the question has
        backButton = findViewById(R.id.backButton);
        answerButton1 = findViewById(R.id.answerButton1);
        answerButton1.setText(quest.getCorrect());
        answerButton2 = findViewById(R.id.answerButton2);
        answerButton2.setText(quest.getIncorrect1());
        answerButton3 = findViewById(R.id.answerButton3);
        answerButton3.setText(quest.getIncorrect2());
        answerButton4 = findViewById(R.id.answerButton4);
        answerButton4.setText(quest.getIncorrect3());
        puzzleDescription = findViewById(R.id.puzDesc);
        puzzleDescription.setText(quest.getQuestion());

        //listeners for all buttons. back button goes back to main
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        //all other buttons send user to the answered screen
        answerButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),AnsweredScreen.class);
                //checkAnswer returns true if the answer is correct. This part is important because
                // later we will randomize what answers go on what buttons
                if (quest.checkAnswer((String) answerButton1.getText())){
                    //puts 1 on the intent if correct
                    intent.putExtra("CORRECT", 1);
                } else {
                    intent.putExtra("CORRECT", 0);
                }
                startActivity(intent);
            }
        });

        answerButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),AnsweredScreen.class);
                boolean answer =quest.checkAnswer((String) answerButton2.getText());
                if (answer){
                    intent.putExtra("CORRECT", 1);
                } else {
                    intent.putExtra("CORRECT", 0);
                }
                startActivity(intent);
            }
        });

        answerButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),AnsweredScreen.class);
                if (quest.checkAnswer((String) answerButton3.getText())){
                    intent.putExtra("CORRECT", 1);
                } else {
                    intent.putExtra("CORRECT", 0);
                }
                startActivity(intent);
            }
        });

        answerButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),AnsweredScreen.class);
                if (quest.checkAnswer((String) answerButton4.getText())){
                    intent.putExtra("CORRECT", 1);
                } else {
                    intent.putExtra("CORRECT", 0);
                }
                startActivity(intent);
            }
        });
    }
}
