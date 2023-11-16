package com.example.prototypeapi22;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Start extends AppCompatActivity {
    int myhand;
    int anotherhand = DecideAnotherhand();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        ImageButton ImageButtonCAT = (ImageButton)findViewById(R.id.imageCAT);
        ImageButton ImageButtonDOG = (ImageButton)findViewById(R.id.imageDOG);
        ImageButton ImageButtonJU = (ImageButton)findViewById(R.id.imageJU);



        ImageButtonCAT.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                myhand = 1;
                if(anotherhand == 1) {
                    ImageView ImageViewCAT = (ImageView)findViewById(R.id.imageViewCat);
                    ImageViewCAT.setAlpha(1f);
                }else if(anotherhand == 2){
                    ImageView ImageViewDOG = (ImageView)findViewById(R.id.imageViewDog);
                    ImageViewDOG.setAlpha(1f);
                }else{
                    ImageView ImageViewJU = (ImageView)findViewById(R.id.imageViewJu);
                    ImageViewJU.setAlpha(1f);
                }
                String resultText = DecideGame(myhand, anotherhand);
                TextView textView2 = (TextView)findViewById(R.id.textView4);
                textView2.setText(resultText);

                Intent intent = new Intent(Start.this,Score.class);
                intent.putExtra("myhand", 1);
                intent.putExtra("anotherhand", anotherhand);
                startActivity(intent);
            }
        });
        ImageButtonDOG.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                myhand = 2;
                if(anotherhand == 1) {
                    ImageView ImageViewCAT = (ImageView)findViewById(R.id.imageViewCat);
                    ImageViewCAT.setAlpha(1f);
                }else if(anotherhand == 2){
                    ImageView ImageViewDOG = (ImageView)findViewById(R.id.imageViewDog);
                    ImageViewDOG.setAlpha(1f);
                }else{
                    ImageView ImageViewJU = (ImageView)findViewById(R.id.imageViewJu);
                    ImageViewJU.setAlpha(1f);
                }
                String resultText = DecideGame(myhand, anotherhand);
                TextView textView2 = (TextView)findViewById(R.id.textView4);
                textView2.setText(resultText);

                Intent intent = new Intent(Start.this,Score.class);
                intent.putExtra("myhand", 2);
                intent.putExtra("anotherhand",anotherhand);
                startActivity(intent);
            }
        });
        ImageButtonJU.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                myhand = 3;
                if(anotherhand == 1) {
                    ImageView ImageViewCAT = (ImageView)findViewById(R.id.imageViewCat);
                    ImageViewCAT.setAlpha(1f);
                }else if(anotherhand == 2){
                    ImageView ImageViewDOG = (ImageView)findViewById(R.id.imageViewDog);
                    ImageViewDOG.setAlpha(1f);
                }else{
                    ImageView ImageViewJU = (ImageView)findViewById(R.id.imageViewJu);
                    ImageViewJU.setAlpha(1f);
                }
                String resultText = DecideGame(myhand, anotherhand);
                TextView textView2 = (TextView)findViewById(R.id.textView4);
                textView2.setText(resultText);

                Intent intent = new Intent(Start.this,Score.class);
                intent.putExtra("myhand", 3);
                intent.putExtra("anotherhand", anotherhand);
                startActivity(intent);
            }
        });

        Button nextButton = (Button)findViewById(R.id.button2);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Start.this,Score.class);
                startActivity(intent);
            }
        });

    }
    int DecideAnotherhand() {
        Random rnd = new Random();
        int hand = rnd.nextInt(3)+1;
        return hand;
    }
    String ChangeTextAnotherhand(int anotherhand) {
        String handText = "";
        if (anotherhand == 1) handText = "グー";
        else if (anotherhand == 2) handText = "チョキ";
        else if (anotherhand == 3) handText = "パー";
        return handText;
    }
    String DecideGame(int myhand, int anotherhand) {
        String decision;
        if ((myhand == 3 && anotherhand == 1) || (myhand+1 == anotherhand)) decision = "WIN";
        else if (myhand == anotherhand) decision = "DRAW";
        else decision = "LOSE";
        return decision;
    }
}