package com.ipn.estructuradedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TextView textView = findViewById(R.id.textView6);
        LottieAnimationView lottieAnimationView = findViewById(R.id.animationView);

        Intent intent = getIntent();
        int score = intent.getExtras().getInt("result");;
        textView.setText(getString(R.string.ten, score));
        if(score < 6) lottieAnimationView.setAnimation(R.raw.confetti_day);
        else lottieAnimationView.setAnimation(R.raw.well_done);
        lottieAnimationView.playAnimation();
        new CountDownTimer(1250, 500)
        {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                lottieAnimationView.pauseAnimation();
            }
        }.start();
    }

    public void exit(View view) {
        finish();
    }
}