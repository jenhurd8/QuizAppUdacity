package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int score = 0;
    boolean radioButton1Correct = false;
    boolean radioButton1Incorrect = false;
    boolean radioButton2Correct = false;
    boolean radioButton2Incorrect = false;

    public void resetScore() {
        score = 0;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.yes_radio_button1:
                if (checked)
                    radioButton1Correct = true;
                radioButton1Incorrect = false;
                break;
            case R.id.no_radio_button1:
                if (checked)
                    radioButton1Correct = false;
                radioButton1Incorrect = true;
                break;
            case R.id.yes_radio_button2:
                if (checked)
                    radioButton2Correct = true;
                radioButton2Incorrect = false;
                break;
            case R.id.no_radio_button2:
                if (checked)
                    radioButton2Correct = false;
                radioButton2Incorrect = true;
                break;
        }
    }

    public void checkScore(View view) {

        /*
         * Question 1 check for lan or LAN
         */
        EditText question1field = (EditText) findViewById(R.id.answer1);
        String question1 = question1field.getText().toString();

        if (question1.equals("LAN") || question1.equals("lan")) {
            score++;
            Log.v("MainActivity", "score at question1: " + score);
        }

        /*
         * Question 2 check for ethernet and cat5 true
         */
        CheckBox wd40CheckBox = (CheckBox) findViewById(R.id.wd40);
        boolean wd40Checked = wd40CheckBox.isChecked();

        CheckBox ethernetCheckBox = (CheckBox) findViewById(R.id.ethernet);
        boolean ethernetChecked = ethernetCheckBox.isChecked();

        CheckBox cat5CheckBox = (CheckBox) findViewById(R.id.cat5);
        boolean cat5Checked = cat5CheckBox.isChecked();

        if (!wd40Checked && ethernetChecked && cat5Checked) {
            score++;
            Log.v("MainActivity", "score at question2: " + score);
        }

        /*
         * Question 3 check for incorrect
         */
        if (radioButton1Incorrect) {
            score++;
            Log.v("MainActivity", "score at question3: " + score);
        }

        /*
         * Question 4 check for wireless true
         */
        if (radioButton2Correct) {
            score++;
            Log.v("MainActivity", "score at question4: " + score);
        }

        /*
         * Question 5 check for Apple and HP checked
         */
        CheckBox appleCheckBox = (CheckBox) findViewById(R.id.apple);
        boolean appleChecked = appleCheckBox.isChecked();

        CheckBox attCheckBox = (CheckBox) findViewById(R.id.att);
        boolean attChecked = attCheckBox.isChecked();

        CheckBox hpCheckBox = (CheckBox) findViewById(R.id.hp);
        boolean hpChecked = hpCheckBox.isChecked();

        if (!attChecked && appleChecked && hpChecked) {
            score++;
            Log.v("MainActivity", "score at question5: " + score);
        }

        /*
         * Final score check and reset score
         */
        Context context = getApplicationContext();
        if (score == 5) {
            CharSequence text = "Congratulations! You received a perfect score: " + score + "/5";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            CharSequence text = "Good job! Your score is: " + score + "/5";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        resetScore();
    }
}
