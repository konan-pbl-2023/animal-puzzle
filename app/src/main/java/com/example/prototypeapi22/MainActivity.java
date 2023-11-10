package com.example.prototypeapi22;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button GU_Button = (Button)findViewById(R.id.button);
        Button TYOKI_Button = (Button)findViewById(R.id.button2);
        Button PA_Button = (Button)findViewById(R.id.button3);
        GU_Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView textView1 = (TextView)findViewById(R.id.textView);
                textView1.setText("GU_Button Clicked!!");
            }
        });

        TYOKI_Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView textView1 = (TextView)findViewById(R.id.textView2);
                textView1.setText("TYOKI_Button Clicked!!");
            }
        });

        PA_Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView textView1 = (TextView)findViewById(R.id.textView3);
                textView1.setText("PA_Button Clicked!!");
            }
        });

    }
}