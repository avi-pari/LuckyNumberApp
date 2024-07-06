package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView   textView2,textViewLuckyNumber;
    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView2 =  findViewById(R.id.textView2);
        textViewLuckyNumber =  findViewById(R.id.textViewLuckyNumber);
        btnShare =  findViewById(R.id.btnShare);

        String userName = getIntent().getStringExtra("name");

        int random_num = generateRandomNumber();
        textViewLuckyNumber.setText(""+random_num);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName,random_num);
            }
        });
    }

    public int generateRandomNumber(){
        Random random = new Random();
        int upper_limit = 1000;

        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;
    }

    public void shareData(String userName , int randomNum){

     Intent i = new Intent(Intent.ACTION_SEND);
     i.setType("text/plain");

     i.putExtra(Intent.EXTRA_SUBJECT,userName + " got lucky today!");
     i.putExtra(Intent.EXTRA_TEXT, " His lucky number is: "+randomNum);
     startActivity(Intent.createChooser(i,"Choose a Platform"));
    }

}