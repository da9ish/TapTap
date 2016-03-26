package com.ddev.game.taptap;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
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
 * Created by Danish Shah on 30/01/2016.
 */
public class Rules extends Fragment {

    int color;
    public int a[];
    public Button button[];
    public TextView time, score;
    public Random r;
    public View v;
    public Vibrator vib;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_rule, container, false);

        final Animation anim_in = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
        final Animation anim_out = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out);
        
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "battlelines.ttf");

        final ImageView home = (ImageView) v.findViewById(R.id.home);

        final RelativeLayout g_1 = (RelativeLayout) v.findViewById(R.id.guide_1);
        final RelativeLayout g_2 = (RelativeLayout) v.findViewById(R.id.guide_2);

        vib = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        g_1.setVisibility(View.VISIBLE);
        g_1.startAnimation(anim_in);        
        
        final TextView t_1 = (TextView) v.findViewById(R.id.guide_text_1);
        final TextView t_2 = (TextView) v.findViewById(R.id.guide_text_2);
        
        t_1.setTypeface(tf);
        t_2.setTypeface(tf);

        final Button b_1 = (Button) v.findViewById(R.id.btn_got_it_1);
        final Button b_2 = (Button) v.findViewById(R.id.btn_got_it_2);
        
        b_1.setTypeface(tf);
        b_2.setTypeface(tf);
        
        b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g_1.startAnimation(anim_out);
                g_1.setVisibility(View.INVISIBLE);
                b_1.setVisibility(View.INVISIBLE);
                t_1.setVisibility(View.INVISIBLE);
                g_2.setVisibility(View.VISIBLE);
                g_2.startAnimation(anim_in);
                b_1.setEnabled(false);
            }
        });

        b_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g_2.startAnimation(anim_out);
                g_2.setVisibility(View.INVISIBLE);
                b_2.setVisibility(View.INVISIBLE);
                t_2.setVisibility(View.INVISIBLE);
                home.setVisibility(View.VISIBLE);
                b_2.setEnabled(false);
                enableBoard();
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
        
        button = new Button[49];

        a = new int[50];
        r = new Random();

        initButton();
        initBoard();
        startGame();
        disableBoard();
        
        return v;
    }

    public void disableBoard() {
        for (int i = 0; i < button.length; i++)
            button[i].setEnabled(false);
    }

    public void enableBoard() {
        for (int i = 0; i < button.length; i++)
            button[i].setEnabled(true);
    }

    private void initButton() {
        for (int i = 0; i < button.length; i++) {
            a[i] = r.nextInt(7);
        }
        color = r.nextInt(7);

        button[0] = (Button) v.findViewById(R.id.button);
        button[1] = (Button) v.findViewById(R.id.button2);
        button[2] = (Button) v.findViewById(R.id.button3);
        button[3] = (Button) v.findViewById(R.id.button4);
        button[4] = (Button) v.findViewById(R.id.button5);
        button[5] = (Button) v.findViewById(R.id.button6);
        button[6] = (Button) v.findViewById(R.id.button7);
        button[7] = (Button) v.findViewById(R.id.button8);
        button[8] = (Button) v.findViewById(R.id.button9);
        button[9] = (Button) v.findViewById(R.id.button10);
        button[10] = (Button) v.findViewById(R.id.button11);
        button[11] = (Button) v.findViewById(R.id.button12);
        button[12] = (Button) v.findViewById(R.id.button13);
        button[13] = (Button) v.findViewById(R.id.button14);
        button[14] = (Button) v.findViewById(R.id.button15);
        button[15] = (Button) v.findViewById(R.id.button16);
        button[16] = (Button) v.findViewById(R.id.button17);
        button[17] = (Button) v.findViewById(R.id.button18);
        button[18] = (Button) v.findViewById(R.id.button19);
        button[19] = (Button) v.findViewById(R.id.button20);
        button[20] = (Button) v.findViewById(R.id.button21);
        button[21] = (Button) v.findViewById(R.id.button22);
        button[22] = (Button) v.findViewById(R.id.button23);
        button[23] = (Button) v.findViewById(R.id.button24);
        button[24] = (Button) v.findViewById(R.id.button25);
        button[25] = (Button) v.findViewById(R.id.button26);
        button[26] = (Button) v.findViewById(R.id.button27);
        button[27] = (Button) v.findViewById(R.id.button28);
        button[28] = (Button) v.findViewById(R.id.button29);
        button[29] = (Button) v.findViewById(R.id.button30);
        button[30] = (Button) v.findViewById(R.id.button31);
        button[31] = (Button) v.findViewById(R.id.button32);
        button[32] = (Button) v.findViewById(R.id.button33);
        button[33] = (Button) v.findViewById(R.id.button34);
        button[34] = (Button) v.findViewById(R.id.button35);
        button[35] = (Button) v.findViewById(R.id.button36);
        button[36] = (Button) v.findViewById(R.id.button37);
        button[37] = (Button) v.findViewById(R.id.button38);
        button[38] = (Button) v.findViewById(R.id.button39);
        button[39] = (Button) v.findViewById(R.id.button40);
        button[40] = (Button) v.findViewById(R.id.button41);
        button[41] = (Button) v.findViewById(R.id.button42);
        button[42] = (Button) v.findViewById(R.id.button43);
        button[43] = (Button) v.findViewById(R.id.button44);
        button[44] = (Button) v.findViewById(R.id.button45);
        button[45] = (Button) v.findViewById(R.id.button46);
        button[46] = (Button) v.findViewById(R.id.button47);
        button[47] = (Button) v.findViewById(R.id.button48);
        button[48] = (Button) v.findViewById(R.id.button49);

    }

    private void initBoard() {

        for (int i = 0; i < button.length; i++) {
            switch (a[i]) {
                case 0:
                    button[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.c_1));
                    break;
                case 1:
                    button[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.c_2));
                    break;
                case 2:
                    button[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.c_3));
                    break;
                case 3:
                    button[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.c_4));
                    break;
                case 4:
                    button[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.c_5));
                    break;
                case 5:
                    button[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.c_6));
                    break;
                case 6:
                    button[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.c_7));
                    break;
            }
        }

        ImageView c_indi = (ImageView) v.findViewById(R.id.indi_color);

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
    }

    private void startGame() {

        for (int i = 0; i < button.length; ++i) {
            final int finalI = i;
            button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (a[finalI] == color) {
                        button[finalI].setVisibility(View.INVISIBLE);
                        a[finalI] = 10;
                    }else {
                        vib.vibrate(200);
                    }
                    check();
                }
            });
        }
    }

    private void check() {
        int j = 0;
        for (int i = 0; i < button.length; i++) {
            if (a[i] != color)
                j++;
        }
        Log.d("APP", "Out of For Loop! " + j);
        if (j == 49) {
            initVisibility();
            initButton();
            initBoard();
            startGame();
        }
    }

    private void initVisibility() {
        for (int i = 0; i < button.length; i++)
            button[i].setVisibility(View.VISIBLE);
    }
}
