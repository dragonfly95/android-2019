package com.example.android101;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdater extends RecyclerView.Adapter<MyAdater.ViewHolder> {

  private ArrayList<MyData> mDataset;

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.alert_dialog, parent, false);
    ViewHolder viewHolder = new ViewHolder(v);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.textView.setText(mDataset.get(position).text);
    holder.imageView.setImageResource(mDataset.get(position).img);
  }

  @Override
  public int getItemCount() {
    return mDataset.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;

    public ViewHolder(View view) {
      super(view);
      imageView = (ImageView) view.findViewById(R.id.image);
      textView = (TextView) view.findViewById(R.id.image);
    }
  }

  public MyAdater(ArrayList<MyData> myDataset) {
    mDataset = myDataset;
  }



}


class MyData {
  public String text;
  public int img;
  public MyData(String text, int img) {
    this.text = text;
    this.img = img;
  }
}