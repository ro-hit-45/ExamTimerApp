package com.example.examtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView done = findViewById(R.id.done);
        final TextView time = findViewById(R.id.number);
        music = MediaPlayer.create(MainActivity.this,R.raw.music);
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText(String.valueOf(millisUntilFinished/1000));

            }

            @Override
            public void onFinish() {

                music.start();
                done.setText("Done");


            }
        }.start();
    }
}