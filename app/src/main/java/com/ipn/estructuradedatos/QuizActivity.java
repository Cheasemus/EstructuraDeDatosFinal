package com.ipn.estructuradedatos;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity
{
    private ProgressBar progressBar;
    private TextView textView;
    private ImageView imageView;
    private ChipGroup chipGroup;
    private Chip chip1;
    private Chip chip2;
    private Chip chip3;
    private Chip chip4;
    private Chip chipNumber;
    private LottieAnimationView lottieAnimationView;
    private List<Questions> quizList;

    private String correctAnswer = "";
    private int count = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(10000);
        progressBar.setProgress(10000);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);

        chipGroup = findViewById(R.id.table);

        chip1 = findViewById(R.id.chip1);
        chip2 = findViewById(R.id.chip2);
        chip3 = findViewById(R.id.chip3);
        chip4 = findViewById(R.id.chip4);
        chipNumber = findViewById(R.id.chipNumber);
        chipNumber.setText(getString(R.string.ten, (count + 1)));

        lottieAnimationView = findViewById(R.id.animationView);

        quizList = Quiz.initQuiz(this);

        Collections.shuffle(quizList);
        init();
        startTimer();
    }

    private void init()
    {
        chipGroup.clearCheck();
        List<Answers> answers = quizList.get(count).shuffleAnswers();

        textView.setText(quizList.get(count).getQuestion());
        imageView.setImageResource(quizList.get(count).getImage());

        chip1.setText(answers.get(0).getAnswer());
        chip2.setText(answers.get(1).getAnswer());
        chip3.setText(answers.get(2).getAnswer());
        chip4.setText(answers.get(3).getAnswer());

        correctAnswer = quizList.get(count).getCorrect();
    }

    private void startTimer()
    {
        long duration = 10000;
        progressBar.setProgress((int) duration);
        ObjectAnimator.ofInt(progressBar, "progress", (int) duration, 0).setDuration(duration).start();
        new CountDownTimer(duration, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                checkSelectedChip();
            }
        }.start();
    }

    private void checkSelectedChip() {
        Chip checkedChip = findViewById(chipGroup.getCheckedChipId());

        if (checkedChip != null) {
            if (checkedChip.getText().equals(correctAnswer)) {
                lottieAnimationView.setAnimation(R.raw.checkmark);
                score++;
            } else lottieAnimationView.setAnimation(R.raw.wrong);
        } else lottieAnimationView.setAnimation(R.raw.wrong);

        lottieAnimationView.playAnimation();
        lottieAnimationView.setVisibility(View.VISIBLE);
        lottieAnimationView.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                lottieAnimationView.removeAllAnimatorListeners();
                if (count < quizList.size()-1)
                {
                    lottieAnimationView.setVisibility(View.GONE);
                    count++;
                    chipNumber.setText(getString(R.string.ten, (count + 1)));
                    init();
                    startTimer();
                }
                else
                {
                    Intent intent = new Intent(QuizActivity.this, ResultsActivity.class);
                    intent.putExtra("result", score);
                    finish();
                    startActivity(intent);
                }
            }
        });
    }
}