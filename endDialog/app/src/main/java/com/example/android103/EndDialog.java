package com.example.android103;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

class EndDialog extends Dialog implements View.OnClickListener {

  private Context context;

  private TextView btn_cancel;
  private TextView btn_ok;

  public EndDialog(Context context) {
    super(context);
    this.context = context;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.dialog_end);

    btn_cancel = findViewById(R.id.btn_cancel);
    btn_ok = findViewById(R.id.btn_ok);

    btn_cancel.setOnClickListener(this);
    btn_ok.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {

    switch (view.getId()) {
      case R.id.btn_cancel:
        dismiss();
        break;
      case R.id.btn_ok:
        ((MainActivity)context).finish();
    }
  }
}
