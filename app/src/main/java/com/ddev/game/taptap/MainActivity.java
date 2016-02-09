package com.ddev.game.taptap;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = 20000;
        inc = 1000;

        btn = new Button[50];

        a = new int[50];
        r = new Random();

        tf = Typeface.createFromAsset(getAssets(), "battlelines.ttf");

        vib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        initTimer();
        initButton();
        initBoard();
        startGame();
    }


    private void initButton() {
        for (int i = 1; i < btn.length; i++) {
            a[i] = r.nextInt(7);
        }
        color = r.nextInt(7);

        btn[1] = (Button) findViewById(R.id.btn1);
        btn[2] = (Button) findViewById(R.id.btn2);
        btn[3] = (Button) findViewById(R.id.btn3);
        btn[4] = (Button) findViewById(R.id.btn4);
        btn[5] = (Button) findViewById(R.id.btn5);
        btn[6] = (Button) findViewById(R.id.btn6);
        btn[7] = (Button) findViewById(R.id.btn7);
        btn[8] = (Button) findViewById(R.id.btn8);
        btn[9] = (Button) findViewById(R.id.btn9);
        btn[10] = (Button) findViewById(R.id.btn10);
        btn[11] = (Button) findViewById(R.id.btn11);
        btn[12] = (Button) findViewById(R.id.btn12);
        btn[13] = (Button) findViewById(R.id.btn13);
        btn[14] = (Button) findViewById(R.id.btn14);
        btn[15] = (Button) findViewById(R.id.btn15);
        btn[16] = (Button) findViewById(R.id.btn16);
        btn[17] = (Button) findViewById(R.id.btn17);
        btn[18] = (Button) findViewById(R.id.btn18);
        btn[19] = (Button) findViewById(R.id.btn19);
        btn[20] = (Button) findViewById(R.id.btn20);
        btn[21] = (Button) findViewById(R.id.btn21);
        btn[22] = (Button) findViewById(R.id.btn22);
        btn[23] = (Button) findViewById(R.id.btn23);
        btn[24] = (Button) findViewById(R.id.btn24);
        btn[25] = (Button) findViewById(R.id.btn25);
        btn[26] = (Button) findViewById(R.id.btn26);
        btn[27] = (Button) findViewById(R.id.btn27);
        btn[28] = (Button) findViewById(R.id.btn28);
        btn[29] = (Button) findViewById(R.id.btn29);
        btn[30] = (Button) findViewById(R.id.btn30);
        btn[31] = (Button) findViewById(R.id.btn31);
        btn[32] = (Button) findViewById(R.id.btn32);
        btn[33] = (Button) findViewById(R.id.btn33);
        btn[34] = (Button) findViewById(R.id.btn34);
        btn[35] = (Button) findViewById(R.id.btn35);
        btn[36] = (Button) findViewById(R.id.btn36);
        btn[37] = (Button) findViewById(R.id.btn37);
        btn[38] = (Button) findViewById(R.id.btn38);
        btn[39] = (Button) findViewById(R.id.btn39);
        btn[40] = (Button) findViewById(R.id.btn40);
        btn[41] = (Button) findViewById(R.id.btn41);
        btn[42] = (Button) findViewById(R.id.btn42);
        btn[43] = (Button) findViewById(R.id.btn43);
        btn[44] = (Button) findViewById(R.id.btn44);
        btn[45] = (Button) findViewById(R.id.btn45);
        btn[46] = (Button) findViewById(R.id.btn46);
        btn[47] = (Button) findViewById(R.id.btn47);
        btn[48] = (Button) findViewById(R.id.btn48);
        btn[49] = (Button) findViewById(R.id.btn49);

    }

    private void initBoard() {

        for (int i = 1; i < btn.length; i++) {
            switch (a[i]) {
                case 0:
                    btn[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.c_1));
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
                case 5:
                    btn[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.c_6));
                    break;
                case 6:
                    btn[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.c_7));
                    break;
            }
        }

        ImageView c_indi = (ImageView) findViewById(R.id.indi_color);

        switch (color) {
            case 0:
                c_indi.setImageDrawable(getResources().getDrawable(R.drawable.c_1));
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
            case 5:
                c_indi.setImageDrawable(getResources().getDrawable(R.drawable.c_6));
                break;
            case 6:
                c_indi.setImageDrawable(getResources().getDrawable(R.drawable.c_7));
                break;
        }

        score = (TextView) findViewById(R.id.score);
        score.setText(Long.toString(sco));
        score.setTypeface(tf);
        time = (TextView) findViewById(R.id.time);
        time.setTypeface(tf);
    }


    private void startGame() {

        int i;

        for (i = 1; i < btn.length; ++i) {
            final int finalI = i;
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (a[finalI] == color) {
                        btn[finalI].setVisibility(View.INVISIBLE);
                        a[finalI] = 10;
                    } else {
                        vib.vibrate(200);
                        if(timer!=0)
                            countDownTimer.cancel();
                        timer -= 5000;
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
        for (int k = 1000;k<=sco;k+=1000){
            if(k>=sco){
                inc+=100;
                if(inc == 3000)
                    inc = 3000;
            }
        }
        for (int i = 1; i < btn.length; i++) {
            if (a[i] != color)
                j++;
        }
        Log.d("APP", "Out of For Loop! " + j);
        if (j == 49) {
            sco = sco + count[0] * 10;
            if(timer!=0)
                countDownTimer.cancel();
            timer += 3000;
            initTimer();
            score.setText(Long.toString(sco));
            initVisibility();
            initButton();
            initBoard();
            startGame();
        }
    }

    private void initTimer() {
        countDownTimer = new CountDownTimer(timer+1000, inc) {
            @Override
            public void onTick(long t) {
                time.setText(Long.toString(t/1000));
                timer=t;

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
        for (int i = 1; i < btn.length; i++)
            btn[i].setVisibility(View.VISIBLE);
    }

    private void stopGame(long score) {

        Intent gOver = new Intent(MainActivity.this, GameOver.class);
        gOver.putExtra("KEY_SCORE", score);
        startActivity(gOver);

        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        finish();
    }



    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(timer!=0)
            countDownTimer.cancel();
        initTimer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
    }
}
