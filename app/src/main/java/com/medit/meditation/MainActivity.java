package com.medit.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = findViewById(R.id.progressBar);


        new Thread(){

            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent(MainActivity.this,Nextactivity.class);
              startActivity(intent);
                finish();

            }

        }.start();


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent=new Intent(MainActivity.this,Nextactivity.class);
//                startActivity(intent);
//                finish();
//            }
//        },5000);


    }
}