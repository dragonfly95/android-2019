package com.example.android101;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.second_main);

    ImageView imageview = findViewById(R.id.imageview);
    TextView textview = findViewById(R.id.textview);

    Bundle extras = getIntent().getExtras();
    String s = extras.getString("string");
    int i = extras.getInt("integer");
    double d = extras.getDouble("double");
    byte[] byteArray = getIntent().getByteArrayExtra("image");
    Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

    String str = s+"\n"+i+"\n"+Double.toString(d)+"\n";
    textview.setText(str);
    imageview.setImageBitmap(bitmap);

  }
}
