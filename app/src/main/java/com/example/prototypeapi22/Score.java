package com.example.prototypeapi22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
        Button nextButton = (Button) findViewById(R.id.RestartButton);
        TextView textView2 = (TextView)findViewById(R.id.textView5);
        ImageButton ImageButtonDog = (ImageButton) findViewById(R.id.imageButton);
        ImageButton ImageButtonJu = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton ImageButtonCat = (ImageButton) findViewById(R.id.imageButton3);
        ImageView ImageViewDog = (ImageView) findViewById(R.id.imageView);
        ImageView ImageViewJu = (ImageView) findViewById(R.id.imageView4);
        ImageView ImageViewCat = (ImageView) findViewById(R.id.imageView12);
        Intent intent = getIntent();
        int myhand1 = intent.getIntExtra("myhand",1);
        int myhand2 = intent.getIntExtra("myhand",2);
        int myhand3 = intent.getIntExtra("myhand",3);
        int anotherhand1 = intent.getIntExtra("anotherhand", 1);
        int anotherhand2 = intent.getIntExtra("anotherhand",2);
        int anotherhand3 = intent.getIntExtra("anotherhand",3);
        String resultText;


       if(myhand1 == 1){
           ImageButtonCat.setAlpha(1f);
       }
        if(myhand2 == 2){
            ImageButtonDog.setAlpha(1f);
        }
        if(myhand3 == 3){
            ImageButtonJu.setAlpha(1f);
        }
        if(anotherhand1 == 1) {
            ImageViewCat.setAlpha(1f);
        }else if(anotherhand2 == 2){
            ImageViewDog.setAlpha(1f);
        }else if(anotherhand3 == 3){
            ImageViewJu.setAlpha(1f);
        }

        if(myhand1 == 1 && anotherhand1 == 1){
            resultText = DecideGame(myhand1, anotherhand1);
            textView2.setText(resultText);
        }if(myhand1 == 1 && anotherhand2 == 2){
            resultText = DecideGame(myhand1, anotherhand2);
            textView2.setText(resultText);
            textView2.setTextColor(Color.RED);
        }if(myhand1 == 1 && anotherhand3 == 3){
            resultText = DecideGame(myhand1, anotherhand3);
            textView2.setText(resultText);
            textView2.setTextColor(Color.BLUE);
        }if(myhand2 == 2 && anotherhand1 == 1){
            resultText = DecideGame(myhand2, anotherhand1);
            textView2.setText(resultText);
            textView2.setTextColor(Color.BLUE);
        }if(myhand2 == 2 && anotherhand2 == 2){
            resultText = DecideGame(myhand2, anotherhand2);
            textView2.setText(resultText);
        }if(myhand2 == 2 && anotherhand3 == 3){
            resultText = DecideGame(myhand2, anotherhand3);
            textView2.setText(resultText);
            textView2.setTextColor(Color.RED);
        }if(myhand3 == 3 && anotherhand1 == 1){
            resultText = DecideGame(myhand3, anotherhand1);
            textView2.setText(resultText);
            textView2.setTextColor(Color.RED);
        }if(myhand3 == 3 && anotherhand2 == 2){
            resultText = DecideGame(myhand3, anotherhand2);
            textView2.setText(resultText);
            textView2.setTextColor(Color.BLUE);
        }if(myhand3 == 3 && anotherhand3 == 3){
            resultText = DecideGame(myhand3, anotherhand3);
            textView2.setText(resultText);
        }

        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Score.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    String DecideGame(int myhand, int anotherhand) {
        String decision;
        if ((myhand == 3 && anotherhand == 1) || (myhand+1 == anotherhand)) decision = "WIN";
        else if (myhand == anotherhand) decision = "DRAW";
        else decision = "LOSE";
        return decision;
    }
}