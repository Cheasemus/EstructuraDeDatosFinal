package com.ipn.estructuradedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    public void goToPlay(View view) {
        startActivity(new Intent(IntroActivity.this, QuizActivity.class));
        finish();
    }
}