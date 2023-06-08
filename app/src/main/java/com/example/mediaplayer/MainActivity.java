package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    TextView tv1;
    Switch s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
        s=findViewById(R.id.s);
    }

    public void iniciar(View v){
        if (mp!=null) {
            mp.release();
        }
        mp=MediaPlayer.create(this, R.raw.lean);
        if(s.isChecked()){
            mp.setLooping(true);
        }
        mp.start();
        tv1.setText("Estado: Reproduciendo");
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                tv1.setText("Estado: Pausado");
            }
        });
    }
    protected void onStop() {
        super.onStop();
        if(mp!=null){
            mp.release();
            mp=null;
        }
    }
    public void pausar(View v){
        if(mp!=null &&  mp.isPlaying()){
            mp.pause();
            tv1.setText("Estado: Pausado");
        }
    }
    public void continuar(View v){
        if(mp!=null && !mp.isPlaying()){
            mp.start();
        }
    }
    public void loop(View v){
        if(s.isChecked()) {
            mp.setLooping(true);
        }else{
            mp.setLooping(false);
        }
    }

}