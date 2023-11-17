package com.example.prototypeapi22;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Start extends AppCompatActivity {

    int mp3a;
    SoundPool soundPool;
    //音楽再生用のメソッド
    public void play_mp3a () {
        soundPool.play(mp3a, 1f, 1f, 0, 0, 1f);
    };
    //変数の宣言
    int myhand;
    int anotherhand = DecideAnotherhand();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        ImageButton ImageButtonCAT = (ImageButton)findViewById(R.id.imageCAT);
        ImageButton ImageButtonDOG = (ImageButton)findViewById(R.id.imageDOG);
        ImageButton ImageButtonJU = (ImageButton)findViewById(R.id.imageJU);

        //soundPoolの初期化
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {

            //1個目のパラメーターはリソースの数に合わせる
            soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);

        } else {
            AudioAttributes attr = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(attr)
                    //パラメーターはリソースの数に合わせる
                    .setMaxStreams(2)
                    .build();
        }
        //音楽の読み込み
        mp3a = soundPool.load(this, R.raw.button, 1);


        //猫のボタンを押したときの処理
        ImageButtonCAT.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //play_mp3a();
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

                //画面を遅らせる
                Handler handler = new Handler(Looper.getMainLooper());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(500);
                                    soundPool.stop(mp3a);
                                    soundPool.release();

                                    Intent intent = new Intent(Start.this,Score.class);
                                    intent.putExtra("myhand", 1);
                                    intent.putExtra("anotherhand",anotherhand);

                                    startActivity(intent);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        });
                    }
                }).start();
            }
        });
        //犬のボタンを押したときの処理
        ImageButtonDOG.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //play_mp3a();
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

                //画面を遅らせる
                Handler handler = new Handler(Looper.getMainLooper());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(500);
                                    soundPool.stop(mp3a);
                                    soundPool.release();

                                    Intent intent = new Intent(Start.this,Score.class);
                                    intent.putExtra("myhand", 2);
                                    intent.putExtra("anotherhand",anotherhand);

                                    startActivity(intent);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        });
                    }
                }).start();
            }
        });
        //ジュレヌクのボタンを押したときの処理
        ImageButtonJU.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //play_mp3a();
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

                //画面を遅らせる
                Handler handler = new Handler(Looper.getMainLooper());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(500);
                                    soundPool.stop(mp3a);
                                    soundPool.release();

                                    Intent intent = new Intent(Start.this,Score.class);
                                    intent.putExtra("myhand", 3);
                                    intent.putExtra("anotherhand",anotherhand);

                                    startActivity(intent);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        });
                    }
                }).start();
            }
        });
    }


    //ランダムで相手の手を決定

    int DecideAnotherhand() {
        Random rnd = new Random();
        int hand = rnd.nextInt(3)+1;
        return hand;
    }

}