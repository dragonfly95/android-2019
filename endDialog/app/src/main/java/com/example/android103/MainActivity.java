package com.example.android103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private Context context;

  private Button btn_end;
  private EndDialog mEndDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btn_end = findViewById(R.id.btn_finish);
    btn_end.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btn_finish:
        mEndDialog = new EndDialog(this);
        mEndDialog.setCancelable(false);
        mEndDialog.show();
        break;
    }
  }
}
