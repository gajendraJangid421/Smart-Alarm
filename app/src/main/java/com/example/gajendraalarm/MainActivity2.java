package com.example.gajendraalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

import static java.lang.String.format;

public class MainActivity2 extends AppCompatActivity {

    private TextView mTextView;
    TextView tv_level, tv_number;
    EditText et_number;
    Button b_confirm;
    Button button_cancel;

    int currentLevel = 1;
    int gaj = 7;
    String generateNumber;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_level = findViewById(R.id.tv_level);
        tv_number = findViewById(R.id.tv_number);
        et_number = findViewById(R.id.et_number);
        b_confirm = findViewById(R.id.b_confirm);
        button_cancel = findViewById(R.id.button_cancel);

        et_number.setVisibility(View.GONE);
        b_confirm.setVisibility(View.GONE);
        tv_number.setVisibility(View.VISIBLE);
        button_cancel.setVisibility(View.GONE);

        tv_level.setText(("Level: " + currentLevel));
        generateNumber = (generateNumber(currentLevel));
        tv_number.setText(generateNumber);

        new Handler().postDelayed(() -> {
            et_number.setVisibility(View.VISIBLE);
            b_confirm.setVisibility(View.VISIBLE);
            tv_number.setVisibility(View.GONE);
        } , 1000);

        b_confirm.setOnClickListener(this::onclick);
        button_cancel.setOnClickListener(v -> cancelAlarm());

        button_cancel = (Button) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });
    }

    private String generateNumber(int digits) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < digits; i++) {
            Random rand = new Random();
            int randomDigits = rand.nextInt(10);
            output.append(randomDigits);
        }
        return output.toString();
    }

    private void onclick(View v) {

        if (generateNumber.equals(et_number.getText().toString())) {
            et_number.setVisibility(View.GONE);
            b_confirm.setVisibility(View.GONE);
            tv_number.setVisibility(View.VISIBLE);
            button_cancel.setVisibility(View.GONE);

            et_number.setText("");
            currentLevel++;
            tv_level.setText(("Level: " + currentLevel));
            generateNumber = (generateNumber(currentLevel));
            tv_number.setText(generateNumber);

            new Handler().postDelayed(() -> {
                et_number.setVisibility(View.VISIBLE);
                b_confirm.setVisibility(View.VISIBLE);
                tv_number.setVisibility(View.GONE);
                // button_playAgain.setVisibility(View.VISIBLE);
                et_number.requestFocus();
            } , 1000);
        } else {
            tv_level.setText(format("Game Over! The number was %s" , generateNumber));
            b_confirm.setEnabled(false);
            if (Objects.equals(currentLevel , gaj)) {
                button_cancel.setVisibility(View.VISIBLE);
                button_cancel.setEnabled(true);
            }
        }
        if (currentLevel >= gaj) {
            button_cancel.setVisibility(View.VISIBLE);
            button_cancel.setEnabled(true);
        }
    }

    @SuppressLint("SetTextI18n")
    private void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this , AlarmReceiver.class);
        intent = new Intent(this , MainActivity.class);
        startActivity(intent);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this , 1 , intent , 0);

        alarmManager.cancel(pendingIntent);
        mTextView.setText("Alarm Cancelled");

        // exit(0);
    }
}