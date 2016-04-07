package com.healthsignz.training.activity;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.Handler;
import android.widget.TextView;

import com.healthsignz.training.R;

public class ProgressBarDemoActivity extends AppCompatActivity {

    private Button buttonSorting;
    private ProgressBar progressBar;
    int progressStatus;
    private Handler handler;
    TextView progress_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_demo);

        buttonSorting = (Button) findViewById(R.id.button_sorting);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_circle);
        handler = new Handler();

        progress_count =(TextView)findViewById(R.id.progress_count);
        progress_count.setText("0%");
        buttonSorting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressStatus = 0;
               /* Animation an = new RotateAnimation(0.0f, 90.0f, 150f, 150f);
                an.setFillAfter(true);
                progressBar.startAnimation(an);*/
              /*final ObjectAnimator animator = ObjectAnimator.ofInt(progressBar, "progress", 0, 100);
                animator.setDuration(1000);
                animator.setInterpolator(new DecelerateInterpolator());
                animator.start();*/

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        while (progressStatus < 100) {
                            progressStatus += 1;
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    progress_count.setText(progressStatus + "%");
                                    progressBar.setProgress(progressStatus);
                                    final ObjectAnimator animator = ObjectAnimator.ofInt(progressBar, "progress", 0, 360);
                                    animator.setDuration(1000);
                                    animator.setInterpolator(new DecelerateInterpolator());
                                    animator.start();
                                }
                            });

                        }
                        /*handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(progressStatus);
                                //tv.setText(progressStatus+"");
                            }
                        });*/
                    }
                }).start();
            }
        });
    }
}
