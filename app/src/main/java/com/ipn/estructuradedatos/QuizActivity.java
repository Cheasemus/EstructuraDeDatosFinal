package com.ipn.estructuradedatos;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity
{
    private ProgressBar progressBar;
    private TextView textView;
    private ImageView imageView;
    private ChipGroup chipGroup;
    private final List<Chip> chipList = new ArrayList<>();

    private Chip chipNumber;
    private LottieAnimationView lottieAnimationView;
    private List<Questions> quizList;

    private String correctAnswer = "";
    private CountDownTimer timer;
    private ColorStateList colorStateListWrong;
    private ColorStateList colorStateListCorrect;
    private ObjectAnimator objectAnimator;
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

        chipList.add(findViewById(R.id.chip1));
        chipList.add(findViewById(R.id.chip2));
        chipList.add(findViewById(R.id.chip3));
        chipList.add(findViewById(R.id.chip4));

        chipNumber = findViewById(R.id.chipNumber);
        chipNumber.setText(getString(R.string.ten, (count + 1)));

        colorStateListWrong = ColorStateList.valueOf(getResources().getColor(R.color.chip_wrong, getTheme()));
        colorStateListCorrect = ColorStateList.valueOf(getResources().getColor(R.color.chip_background, getTheme()));

        lottieAnimationView = findViewById(R.id.animationView);

        quizList = Quiz.initQuiz(this);

        Collections.shuffle(quizList);
        init();
        startTimer();
    }

    private void init() {
        chipGroup.clearCheck();
        enableChips(true);
        //chipList.forEach(chip -> chip.setChipBackgroundColor(colorStateListCorrect));

        List<Answers> answers = quizList.get(count).shuffleAnswers();
        textView.setText(quizList.get(count).getQuestion());
        imageView.setImageResource(quizList.get(count).getImage());

        for (int i = 0; i < 4; i++) chipList.get(i).setText(answers.get(i).getAnswer());

        correctAnswer = quizList.get(count).getCorrect();
        chipGroup.setOnCheckedChangeListener((group, checkedId) -> checkSelectedChip());
    }

    private void startTimer() {
        long duration = 10000;
        progressBar.setProgress((int) duration);
        objectAnimator = ObjectAnimator.ofInt(progressBar, "progress", (int) duration, 0).setDuration(duration);
        objectAnimator.start();
        timer = new CountDownTimer(duration, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Chip checkedChip = findViewById(chipGroup.getCheckedChipId());
                if(checkedChip == null) checkSelectedChip();
            }
        }.start();
    }

    private void wrongSelection() {
        chipList.forEach(chip -> {
            if (chip.getText().equals(correctAnswer)) {
                //chip.setChipBackgroundColor(colorStateListWrong);
                chipGroup.check(chip.getId());
            }
        });
        lottieAnimationView.setAnimation(R.raw.wrong);
    }

    private void enableChips(boolean enable) {
        chipList.forEach(chip -> {
            chip.setFocusable(enable);
            chip.setClickable(enable);
        });
    }

    private void checkSelectedChip() {
        chipGroup.setOnCheckedChangeListener(null);

        Chip checkedChip = findViewById(chipGroup.getCheckedChipId());
        timer.cancel();
        objectAnimator.cancel();

        if (checkedChip != null) {
            if (checkedChip.getText().equals(correctAnswer)) {
                lottieAnimationView.setAnimation(R.raw.checkmark);
                score++;
            } else wrongSelection();
        } else wrongSelection();

        enableChips(false);

        lottieAnimationView.playAnimation();
        lottieAnimationView.setVisibility(View.VISIBLE);
        lottieAnimationView.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                lottieAnimationView.removeAllAnimatorListeners();
                new CountDownTimer(500, 500)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        if (count < quizList.size()-1) {
                            lottieAnimationView.setVisibility(View.GONE);
                            count++;
                            chipNumber.setText(getString(R.string.ten, (count + 1)));
                            init();
                            startTimer();
                        }
                        else {
                            Intent intent = new Intent(QuizActivity.this, ResultsActivity.class);
                            intent.putExtra("result", score);
                            finish();
                            startActivity(intent);
                        }
                    }
                }.start();
            }
        });
    }
}