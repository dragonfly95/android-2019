package com.example.android101;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class FirstActivity extends AppCompatActivity {

  int Fist_activity = R.layout.first_main;

  ImageView imageView;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(Fist_activity);


    imageView = findViewById(R.id.imageview);
    findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){

      @Override
      public void onClick(View view) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        float scale = (float) (1024/(float)bitmap.getWidth());
        int image_w = (int) (bitmap.getWidth() * scale);
        int image_h = (int) (bitmap.getHeight() * scale);

        Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
        resize.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        intent.putExtra("string", "intent 연습");
        intent.putExtra("integer", 300);
        intent.putExtra("double", 3.141592 );
        intent.putExtra("image", byteArray);

        startActivity(intent);

      }
    });
  }
}
