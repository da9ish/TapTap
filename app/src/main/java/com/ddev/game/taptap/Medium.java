package com.ddev.game.taptap;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Danish Shah on 24/03/2016.
 */
public class Medium extends Fragment {

    int color;
    public static long timer, inc;
    public long sco = 0;
    public int a[];
    public Button btn[];
    public TextView time, score;
    public Random r;
    final int[] count = {0};
    public CountDownTimer countDownTimer;
    public Typeface tf;
    public Vibrator vib;
    public View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_med, container, false);

        timer = 20000;
        inc = 1000;

        final Animation anim_in = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
        final Animation anim_out = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out);

        btn = new Button[25];

        a = new int[25];
        r = new Random();

        tf = Typeface.createFromAsset(getContext().getAssets(), "battlelines.ttf");

        vib = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        final RelativeLayout p = (RelativeLayout) v.findViewById(R.id.pause);

        final ImageView home = (ImageView) v.findViewById(R.id.ic_home);
        final ImageView play = (ImageView) v.findViewById(R.id.ic_play);
        ImageView pause = (ImageView) v.findViewById(R.id.ic_pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableBoard();
                play.setEnabled(true);
                home.setEnabled(true);
                play.setVisibility(View.VISIBLE);
                p.setVisibility(View.VISIBLE);
                p.startAnimation(anim_in);
                onPause();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableBoard();
                play.setEnabled(false);
                home.setEnabled(false);
                play.setVisibility(View.GONE);
                p.startAnimation(anim_out);
                p.setVisibility(View.GONE);
                onResume();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new Menu())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });

        initTimer();
        initButton();
        initBoard();
        startGame();

        return v;
    }

    public void disableBoard() {
        for (int i = 0; i < btn.length; i++)
            btn[i].setEnabled(false);
    }

    public void enableBoard() {
        for (int i = 0; i < btn.length; i++)
            btn[i].setEnabled(true);
    }

    private void initButton() {
        for (int i = 0; i < btn.length; i++) {
            a[i] = r.nextInt(5);
        }
        color = r.nextInt(5);

        btn[0] = (Button) v.findViewById(R.id.btn1);
        btn[1] = (Button) v.findViewById(R.id.btn2);
        btn[2] = (Button) v.findViewById(R.id.btn3);
        btn[3] = (Button) v.findViewById(R.id.btn4);
        btn[4] = (Button) v.findViewById(R.id.btn5);
        btn[5] = (Button) v.findViewById(R.id.btn6);
        btn[6] = (Button) v.findViewById(R.id.btn7);
        btn[7] = (Button) v.findViewById(R.id.btn8);
        btn[8] = (Button) v.findViewById(R.id.btn9);
        btn[9] = (Button) v.findViewById(R.id.btn10);
        btn[10] = (Button) v.findViewById(R.id.btn11);
        btn[11] = (Button) v.findViewById(R.id.btn12);
        btn[12] = (Button) v.findViewById(R.id.btn13);
        btn[13] = (Button) v.findViewById(R.id.btn14);
        btn[14] = (Button) v.findViewById(R.id.btn15);
        btn[15] = (Button) v.findViewById(R.id.btn16);
        btn[16] = (Button) v.findViewById(R.id.btn17);
        btn[17] = (Button) v.findViewById(R.id.btn18);
        btn[18] = (Button) v.findViewById(R.id.btn19);
        btn[19] = (Button) v.findViewById(R.id.btn20);
        btn[20] = (Button) v.findViewById(R.id.btn21);
        btn[21] = (Button) v.findViewById(R.id.btn22);
        btn[22] = (Button) v.findViewById(R.id.btn23);
        btn[23] = (Button) v.findViewById(R.id.btn24);
        btn[24] = (Button) v.findViewById(R.id.btn25);

    }

    private void initBoard() {

        for (int i = 0; i < btn.length; i++) {
            switch (a[i]) {
                case 0:
                    btn[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.c_6));
                    break;
                case 1:
                    btn[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.c_2));
                    break;
                case 2:
                    btn[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.c_3));
                    break;
                case 3:
                    btn[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.c_4));
                    break;
                case 4:
                    btn[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.c_5));
                    break;
            }
        }

        ImageView c_indi = (ImageView) v.findViewById(R.id.indi_color);

        switch (color) {
            case 0:
                c_indi.setImageDrawable(getResources().getDrawable(R.drawable.c_6));
                break;
            case 1:
                c_indi.setImageDrawable(getResources().getDrawable(R.drawable.c_2));
                break;
            case 2:
                c_indi.setImageDrawable(getResources().getDrawable(R.drawable.c_3));
                break;
            case 3:
                c_indi.setImageDrawable(getResources().getDrawable(R.drawable.c_4));
                break;
            case 4:
                c_indi.setImageDrawable(getResources().getDrawable(R.drawable.c_5));
                break;
        }

        score = (TextView) v.findViewById(R.id.score);
        score.setText(Long.toString(sco));
        score.setTypeface(tf);
        time = (TextView) v.findViewById(R.id.time);
        time.setTypeface(tf);
    }


    private void startGame() {

        for (int i = 0; i < btn.length; ++i) {
            final int finalI = i;
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (a[finalI] == color) {
                        btn[finalI].setVisibility(View.INVISIBLE);
                        a[finalI] = 10;
                    } else {
                        vib.vibrate(200);
                        if (timer != 0)
                            countDownTimer.cancel();
                        timer -= 3000;
                        initTimer();
                    }
                    count[0]++;
                    check();
                }
            });
        }

    }

    private void check() {
        int j = 0;

        for (int i = 0; i < btn.length; i++) {
            if (a[i] != color)
                j++;
        }

        Log.d("APP", "Out of For Loop! " + j);

        if (j == 25) {
            sco = sco + count[0];
            if (timer != 0)
                countDownTimer.cancel();
            timer += 1000;
            initTimer();
            score.setText(Long.toString(sco));
            initVisibility();
            initButton();
            initBoard();
            startGame();
        }
    }

    private void initTimer() {
        countDownTimer = new CountDownTimer(timer, inc) {
            @Override
            public void onTick(long t) {
                time.setText(Long.toString(t / 1000));
                timer = t;

                Log.d("APP", "Time is" + t / 1000);
            }

            @Override
            public void onFinish() {
                stopGame(sco);
                Log.d("APP", "OnFinish Executed " + sco);
            }
        }.start();
    }


    private void initVisibility() {
        for (int i = 0; i < btn.length; i++)
            btn[i].setVisibility(View.VISIBLE);
    }

    private void stopGame(long score) {

        GameOver g = new GameOver();
        g.setLevel(2);
        g.setCscore(score);

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, g)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }


    @Override
    public void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    @Override
    public void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (timer != 0)
            countDownTimer.cancel();
        initTimer();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
    }
}
