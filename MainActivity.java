package com.example.android.quizapp;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Correct user answers
    int nmbrCorrect = 0;
    //Total possible correct answers
    int possibleCorrect = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Question 1: Checking for the correct radio button selected.
    // Correct answer is Three
    public void questionOneAnswer() {
        RadioButton oneCorrectAnswer = findViewById(R.id.question_one_correct);
        if (oneCorrectAnswer.isChecked()) {
            nmbrCorrect += 1;
        }
    }

    // Question 2: Checking for the correct text input from user
    // Correct answer is Antarctica.
    public void questionTwoAnswer() {
        EditText answerTwo = findViewById(R.id.question_two_answer);
        String answer = answerTwo.getText().toString();
        if (answer.equalsIgnoreCase("Antarctica")) {
            nmbrCorrect += 1;
        }
    }

    // Question 3: Check for all correct checkbox selections
    // Correct incorrect answer is "alchohol".
    public void questionThreeAnswer() {
        CheckBox checkboxOne = findViewById(R.id.qthree_checkbox_one);
        CheckBox checkboxTwo = findViewById(R.id.qthree_checkbox_two);
        CheckBox checkboxThree = findViewById(R.id.qthree_checkbox_three);
        CheckBox checkboxFour = findViewById(R.id.qthree_checkbox_four);

        if (checkboxTwo.isChecked() && checkboxThree.isChecked() && checkboxFour.isChecked() && !checkboxOne.isChecked()) {
            nmbrCorrect += 1;
        }
    }

    // Question 4: Checking for the correct radio button selection.
    // Correct answer is TRUE.
    public void questionFourAnswer() {
        RadioButton fourCorrectAnswer = findViewById(R.id.question_four_true);
        if (fourCorrectAnswer.isChecked()) {
            nmbrCorrect += 1;
        }
    }

    // Calculating final score when Submit Answer answer button is clicked.
    // Will also display a toast message with quiz score results.
    public void answersSubmit(View view) {
        nmbrCorrect = 0;
        questionOneAnswer();
        questionTwoAnswer();
        questionThreeAnswer();
        questionFourAnswer();

        if (nmbrCorrect == possibleCorrect) {
            Toast.makeText(this, "Congrats Smarty Pants! You got them all right",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Whoops, you only got " + nmbrCorrect + " out of " + possibleCorrect + " correct answers.",
                    Toast.LENGTH_LONG).show();
        }
    }
}
