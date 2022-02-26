package com.example.gajendraalarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.Random;

import static java.lang.System.exit;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    Button button5, button6, button7, button8;
    Button button_change2;
    private Question question = new Question();
    TextView question_text;
    private String answer;
    private int questionlength = question.questions.length;
    Random random;
    private BreakIterator mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        random = new Random();

        button_change2 =(Button) findViewById(R.id.button_change2);
        button_change2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainActivity2();
            }
        });

        button_change2.setVisibility(View.GONE);

        button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button6 = (Button)findViewById(R.id.button6);
        button6.setOnClickListener(this);

        button7 = (Button)findViewById(R.id.button7);
        button7.setOnClickListener(this);

        button8 = (Button)findViewById(R.id.button8);
        button8.setOnClickListener(this);

        question_text = (TextView)findViewById(R.id.question);
        NextQuestion(random.nextInt(questionlength));
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button5:
                if (button5.getText()==answer){
                    Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    button_change2.setVisibility(View.VISIBLE);
                    button_change2.setEnabled(true);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                }else{
                    Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    NextQuestion(random.nextInt(questionlength));
//                    GameOver();
                }
                break;
            case R.id.button6:
                if (button6.getText()==answer){
                    Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    button_change2.setVisibility(View.VISIBLE);
                    button_change2.setEnabled(true);
                    button5.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                }else{
                    Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    NextQuestion(random.nextInt(questionlength));
           //         GameOver();
                }
                break;
            case R.id.button7:
                if (button7.getText()==answer){
                    Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    button_change2.setVisibility(View.VISIBLE);
                    button_change2.setEnabled(true);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button8.setEnabled(false);
                }else{
                    Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    NextQuestion(random.nextInt(questionlength));
                    //GameOver();
                }
                break;
            case R.id.button8:
                if (button8.getText()==answer){
                    Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    button_change2.setVisibility(View.VISIBLE);
                    button_change2.setEnabled(true);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                }else{
                    Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    NextQuestion(random.nextInt(questionlength));
                  //  GameOver();
                }
                break;
        }

    }

//    private void GameOver() {
//        AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity3.this);
//        alertdialog.setMessage("Game Over")
//                .setCancelable(false)
//                .setPositiveButton("New Game" , new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog , int which) {
//                        startActivity(new Intent(getApplicationContext(), MainActivity3.class));
//                    }
//                }).setNegativeButton("exit" , new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog , int which) {
//                exit(0);
//            }
//        });
//        alertdialog.show();
//    }

    private void NextQuestion(int num) {
        question_text.setText(question.getQuestion(num));
        button5.setText(question.getChoices1(num));
        button6.setText(question.getChoices2(num));
        button7.setText(question.getChoices3(num));
        button8.setText(question.getChoices4(num));
        answer = question.getCorrectAnswer(num);
    }

    public void openMainActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

}