package com.medit.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Musicactivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {


    private MediaPlayer mediaPlayer;
private SeekBar seekBar;
    private SeekBar seekBar12;
private Timer timer;
private AudioManager audioManager;
private TextView textView;
private Button button1;

    private Button button2;
     String song="";
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.pause();
        timer.cancel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicactivity);
        getSupportActionBar().setTitle("Your song");
        ImageView imageView = findViewById(R.id.image);

        this.song = getIntent().getStringExtra("songname");
        Bitmap bitmap = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("image"), 0, getIntent().getByteArrayExtra("image").length);
        imageView.setImageBitmap(bitmap);
button1=findViewById(R.id.play);
        button2=findViewById(R.id.pause);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });
        seekBar=findViewById(R.id.seekBar1);

        seekBar12=findViewById(R.id.seekBar2);
        play(song);


seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(b){
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
});

seekBar12.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(b) {
            mediaPlayer.seekTo(i);
        }// play music from the seek progress it reset the music where we set the music
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
mediaPlayer.pause();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
mediaPlayer.start();
    }
});



    }
    public void play(String song){

        if (song.equals("sleep")){
            mediaPlayer = MediaPlayer.create(this, R.raw.sleeping); // set music to media player
        }else if(song.equals("birds")){
            mediaPlayer = MediaPlayer.create(this, R.raw.imagine); // set music to media player

        }else if(song.equals("gym")){
            mediaPlayer = MediaPlayer.create(this,R.raw.imagine); // set music to media player

        }else if(song.equals("yogga")){
            mediaPlayer = MediaPlayer.create(this, R.raw.flute); // set music to media player

        }
        mediaPlayer.start();



        audioManager=(AudioManager) getSystemService(AUDIO_SERVICE);
        int maxvolume=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentvol=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        seekBar12.setMax(mediaPlayer.getDuration());

        seekBar.setMax(maxvolume); // set limit for seekbar
        seekBar.setProgress(currentvol);


        textView=findViewById(R.id.textView2);

        int min=mediaPlayer.getDuration()/60000;

        textView.setText(String.valueOf(min)+" min");
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                seekBar12.setProgress(mediaPlayer.getCurrentPosition());

            }
        },0,1000);

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        Toast.makeText(this,"Music starting again enjoy",Toast.LENGTH_LONG).show();
        timer.cancel();
mediaPlayer.reset();
    }
}