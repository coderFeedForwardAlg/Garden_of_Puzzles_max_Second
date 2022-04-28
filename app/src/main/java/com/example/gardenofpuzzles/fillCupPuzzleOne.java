package com.example.gardenofpuzzles;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


    // TODO: make an object where you pass in an array of bucket values and it make the buckets.
public class fillCupPuzzleOne extends PuzzleActivity {

    TextView textView;

    Button fillButton;
    Button emptyButton;

    Button fiveUnitButton;
    Button threeUnitButton;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityf_fill_cup_one);
        textView = findViewById(R.id.textView);

        fillButton = findViewById(R.id.fill);
        emptyButton = findViewById(R.id.empty);
        submitButton = findViewById(R.id.submit);

        fiveUnitButton = findViewById(R.id.fiveUnitCUp);
        threeUnitButton = findViewById(R.id.threeUnitCup);
            //set the number the player will win with



        fillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jug.setToFill();
            }
        });

        emptyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jug.setToEmpty();
            }
        });



        Jug.setDesiredNumber(2);

        Jug jugFive = new Jug(5, fiveUnitButton);
        Jug jugThree = new Jug(3, threeUnitButton);


        Jug[] jugs = {jugFive, jugThree};

        fillCupPuz puzzleFirst = new fillCupPuz(jugs, textView, 1);
        puzzleFirst.makePuzzle();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(puzzleFirst.if_win){
                    Intent intent = new Intent(getApplicationContext(), win.class);
                    startActivity(intent);
                }
            }
        });



    }
}