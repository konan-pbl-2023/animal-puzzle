package com.example.prototypeapi22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    int mp3a;
    int mp3b;
    int mp3c;
    SoundPool soundPool;
    String resultText;

    public void play_mp3 (int mp3) {
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int ringVol = audioManager.getStreamVolume(AudioManager.STREAM_RING);
        soundPool.play(mp3, ringVol, ringVol, 0, 0, 1f);
    };
    //変数の宣言
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
        //soundPoolの初期化
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {

            //1個目のパラメーターはリソースの数に合わせる
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        } else {
            AudioAttributes attr = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(attr)
                    //パラメーターはリソースの数に合わせる
                    .setMaxStreams(1)
                    .build();
        }
        //
        mp3a = soundPool.load(this, R.raw.yeh, 1);
        mp3b = soundPool.load(this, R.raw.bird, 1);
        mp3c = soundPool.load(this, R.raw.lose, 1);

        soundPool.setOnLoadCompleteListener((soundPool, sampleId, status) -> {
            Log.d("debug","sampleId="+sampleId);
            Log.d("debug","status="+status);

            //前の画面で押されたボタンと表示された画像の表示
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

            //各ボタンが押された時の判定の表示
            if(myhand1 == 1 && anotherhand1 == 1){
                resultText = DecideGame(myhand1, anotherhand1);
                textView2.setText(resultText);
            }
            else if(myhand1 == 1 && anotherhand2 == 2){
                resultText = DecideGame(myhand1, anotherhand2);
                textView2.setText(resultText);
                textView2.setTextColor(Color.RED);
            }else if(myhand1 == 1 && anotherhand3 == 3){
                resultText = DecideGame(myhand1, anotherhand3);
                textView2.setText(resultText);
                textView2.setTextColor(Color.BLUE);
            }else if(myhand2 == 2 && anotherhand1 == 1){
                resultText = DecideGame(myhand2, anotherhand1);
                textView2.setText(resultText);
                textView2.setTextColor(Color.BLUE);
            }else if(myhand2 == 2 && anotherhand2 == 2){
                resultText = DecideGame(myhand2, anotherhand2);
                textView2.setText(resultText);
            }else if(myhand2 == 2 && anotherhand3 == 3){
                resultText = DecideGame(myhand2, anotherhand3);
                textView2.setText(resultText);
                textView2.setTextColor(Color.RED);
            }else if(myhand3 == 3 && anotherhand1 == 1){
                resultText = DecideGame(myhand3, anotherhand1);
                textView2.setText(resultText);
                textView2.setTextColor(Color.RED);
            }else if(myhand3 == 3 && anotherhand2 == 2){
                resultText = DecideGame(myhand3, anotherhand2);
                textView2.setText(resultText);
                textView2.setTextColor(Color.BLUE);
            }else if(myhand3 == 3 && anotherhand3 == 3){
                resultText = DecideGame(myhand3, anotherhand3);
                textView2.setText(resultText);
            }
        });



        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Score.this, Start.class);
                startActivity(intent);
            }
        });
    }

    //結果の判定
    String DecideGame(int myhand, int anotherhand) {
        String decision;
        if ((myhand == 3 && anotherhand == 1) || (myhand+1 == anotherhand)) {
            decision = " WIN";
            play_mp3(mp3a);
        } else if(myhand == anotherhand) {
            decision = "DRAW";
            play_mp3(mp3b);
        }else{
            decision = "LOSE";
            play_mp3(mp3c);
        }
        return decision;
    }
}