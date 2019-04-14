package com.konukmehmet.kelimelik;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button answer1,answer2,answer3,answer4, checkingButton,reset;
    TextView score,checkItsCorrect,question;
    ImageView questionPicture;

    private Questions mQuestions = new Questions();
    String mAnswer;
    private int mScore = 0;
    private int questions = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer1 = findViewById(R.id.btnA);
        answer2 = findViewById(R.id.btnB);
        answer3 = findViewById(R.id.btnC);
        answer4 = findViewById(R.id.btnD);
        checkingButton = findViewById(R.id.btnCheck);
        reset = findViewById(R.id.btnReset);
        questionPicture = findViewById(R.id.imageView);
        score = findViewById(R.id.tvScore);
        question = findViewById(R.id.tvQuestion);
        checkItsCorrect = findViewById(R.id.tvCorrect);

        updateQuestion(questions++);
        checkItsCorrect.setText("");


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkItsCorrect.append(answer1.getText());
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkItsCorrect.append(answer2.getText());
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkItsCorrect.append(answer3.getText());
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkItsCorrect.append(answer4.getText());
            }
        });
        checkingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswer.equals(checkItsCorrect.getText().toString())){
                    ++mScore;
                    score.setText("Score : " + mScore);
                    updateQuestion(questions++);
                    checkItsCorrect.setText("");
                    if (mScore == mQuestions.mQuestion.length-1){
                        finished();
                    }

                }
                else {
                    gameOver();
                }

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkItsCorrect.setText("");
            }
        });

    }

    private void gameOver() {
        AlertDialog.Builder alerDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alerDialogBuilder.setMessage("Game Over! Your Score is " + mScore + " points").setCancelable(false).setPositiveButton("New Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = alerDialogBuilder.create();
        alertDialog.show();
    }

    private void finished() {
        AlertDialog.Builder alerDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alerDialogBuilder.setMessage("Congratulations :) Your Score is " + mScore + " points").setCancelable(false).setPositiveButton("New Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = alerDialogBuilder.create();
        alertDialog.show();
    }

    private void updateQuestion(int a) {
        questionPicture.setImageResource(mQuestions.getPicture(a));
        question.setText(mQuestions.getQuestion(a));
        answer1.setText(mQuestions.getChoice1(a));
        answer2.setText(mQuestions.getChoice2(a));
        answer3.setText(mQuestions.getChoice3(a));
        answer4.setText(mQuestions.getChoice4(a));
        mAnswer = mQuestions.getCorrectAnswer(a);
    }
}
