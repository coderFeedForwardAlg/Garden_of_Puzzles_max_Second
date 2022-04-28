package com.example.gardenofpuzzles;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class fillCupPuz {
    public boolean if_win;
    public static Jug[] arr;
    public static TextView textView;
    public int pc;

    fillCupPuz(Jug arr_[], TextView textView_, int pc){
        arr = arr_;
        textView = textView_;
        if_win = false;
        this.pc = pc;

    }



    public void makePuzzle(){
        for(int i = 0; i < arr.length; i++){
            Jug jug = arr[i];
            jug.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    jug.ifClicked();
                    check_if_win();
                }
            });
        }
    }

    public void check_if_win(){
        for(int i = 0; i < arr.length; i++){
            if(arr[i].currentAmount == arr[i].desiredNumber){
                if_win = true;
            }
        }
    }


}
