package com.ipn.estructuradedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();

        ImageView imageView = findViewById(R.id.imageViewBackground);
        TextView textView = findViewById(R.id.textViewTitle);
        TextView textViewInfo = findViewById(R.id.textViewInfo);
        textViewInfo.setMovementMethod(new ScrollingMovementMethod());

        textView.setText(intent.getExtras().get("name").toString());
        textViewInfo.setText(intent.getExtras().get("description").toString());
        imageView.setImageResource(Integer.parseInt(intent.getExtras().get("image").toString()));
    }

    public void back(View view) {
        finish();
    }
}