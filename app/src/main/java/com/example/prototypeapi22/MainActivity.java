package com.example.prototypeapi22;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int myhand;
    int anotherhand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button GU_Button = (Button)findViewById(R.id.button);
        Button TYOKI_Button = (Button)findViewById(R.id.button2);
        Button PA_Button = (Button)findViewById(R.id.button3);
        GU_Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                myhand = 1;
            }
        });

        TYOKI_Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                myhand = 2;
            }
        });

        PA_Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                myhand = 3;
            }
        });

    }
}