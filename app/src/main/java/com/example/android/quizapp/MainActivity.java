package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int score = 0;

    public void checkScore(View view){
        /*
         * Question 1 check for lan or LAN
         */
        EditText question1field = (EditText) findViewById(R.id.answer1);
        String question1 = question1field.getText().toString();

        if(question1.equals("LAN")||question1.equals("lan")){
            score++;
            Log.v("MainActivity", "score at question1: " + score);
        }
        /*
         * Question 2 check for ethernet and cat5 true
         */
        CheckBox wd40CheckBox = (CheckBox)findViewById(R.id.wd40);
        boolean wd40Checked = wd40CheckBox.isChecked();

        CheckBox ethernetCheckBox = (CheckBox)findViewById(R.id.ethernet);
        boolean ethernetChecked = ethernetCheckBox.isChecked();

        CheckBox cat5CheckBox = (CheckBox)findViewById(R.id.cat5);
        boolean cat5Checked = cat5CheckBox.isChecked();

        if(!wd40Checked && ethernetChecked && cat5Checked){
            score++;
            Log.v("MainActivity", "score at question2: " + score);
        }


        /*
         * Question 3 check for incorrect
         */

        /*
         * Question 4 check for ethernet and cat5 true
         */

        /*
         * Question 5 check for ethernet and cat5 true
         */

    }
}
