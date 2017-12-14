package com.example.dell.tictactoe;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.R.attr.onClick;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView play = (ImageView) findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      //  Toast toast = Toast.makeText(getApplicationContext(), "game ON", Toast.LENGTH_SHORT);
        //toast.show();
        final MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(), R.raw.play);
        mplayer.start();
        mplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mplayer.release();
            }
        });
        Intent gameIntent = new Intent(MainActivity.this , GameActivity.class);
        startActivity(gameIntent);
    }
});


    }
}
