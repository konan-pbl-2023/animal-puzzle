package com.example.prototypeapi22;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int myhand;
    int anotherhand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton ImageButtonCAT = (ImageButton)findViewById(R.id.imageCAT);
        ImageButton ImageButtonDOG = (ImageButton)findViewById(R.id.imageDOG);
        ImageButton ImageButtonJU = (ImageButton)findViewById(R.id.imageJU);


        ImageButtonCAT.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                myhand = 1;
            }
        });
        ImageButtonDOG.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                myhand = 2;
            }
        });
        ImageButtonJU.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                myhand = 3;
            }
        });
    }
}