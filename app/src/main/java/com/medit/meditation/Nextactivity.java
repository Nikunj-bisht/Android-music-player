package com.medit.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class Nextactivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextactivity);

        ImageView sleepimg = findViewById(R.id.sleep);

        ImageView joggimg = findViewById(R.id.jogg);

        ImageView exerimg = findViewById(R.id.exer);

        ImageView yogaimg = findViewById(R.id.yoga);

        sleepimg.setOnClickListener(Nextactivity.this);
joggimg.setOnClickListener(Nextactivity.this);
exerimg.setOnClickListener(Nextactivity.this);
yogaimg.setOnClickListener(Nextactivity.this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.sleep:
                Intent intent = new Intent(this,Musicactivity.class);

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.sleep);

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream);

                byte[] bytes = byteArrayOutputStream.toByteArray();
                intent.putExtra("image",bytes);
                intent.putExtra("songname","sleep");
                startActivity(intent);
                break;

            case R.id.jogg:
                Intent intent1 = new Intent(this,Musicactivity.class);

                Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.drawable.jogging);

                ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();

                bitmap1.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream1);

                byte[] bytes1 = byteArrayOutputStream1.toByteArray();
                intent1.putExtra("image",bytes1);
                intent1.putExtra("songname","birds");

                startActivity(intent1);
                break;

            case R.id.exer:
                Intent intent3 = new Intent(this,Musicactivity.class);

                Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(),R.drawable.exercise);

                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();

                bitmap3.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream3);

                byte[] bytes3 = byteArrayOutputStream3.toByteArray();
                intent3.putExtra("image",bytes3);
                intent3.putExtra("songname","gym");

                startActivity(intent3);
                break;

            case R.id.yoga:
                Intent intent4 = new Intent(this,Musicactivity.class);

                Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(),R.drawable.yoga);

                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();

                bitmap4.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream4);

                byte[] bytes4 = byteArrayOutputStream4.toByteArray();
                intent4.putExtra("image",bytes4);
                intent4.putExtra("songname","yogga");

                startActivity(intent4);
                break;



        }


    }
}