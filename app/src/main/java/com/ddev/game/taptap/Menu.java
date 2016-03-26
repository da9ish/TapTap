package com.ddev.game.taptap;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Danish Shah on 24/03/2016.
 */
public class Menu extends Fragment {

    public static boolean isPlaying;
    public boolean music;
    MediaPlayer mp;
    ImageView easy, med, hard, volume, hscore, info, rate, rule, r_image, modes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        final SharedPreferences sPref = getContext().getSharedPreferences("TapTap!", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sPref.edit();

        final Animation anim_in = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
        final Animation anim_out = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out);

        music = sPref.getBoolean("MUSIC", true);
        isPlaying = music;
        mp = MediaPlayer.create(getContext(), R.raw.back_music);
        if(music) {
            mp.start();
            mp.setLooping(true);
            mp.setVolume(100, 100);
        }

        TextView title = (TextView) v.findViewById(R.id.title);
        volume = (ImageView) v.findViewById(R.id.volume);
        rate = (ImageView) v.findViewById(R.id.rate);
        rule = (ImageView) v.findViewById(R.id.rule);
        easy = (ImageView) v.findViewById(R.id.ic_easy);
        med = (ImageView) v.findViewById(R.id.ic_med);
        hard = (ImageView) v.findViewById(R.id.ic_hard);
        hscore = (ImageView) v.findViewById(R.id.high_score);
        info = (ImageView) v.findViewById(R.id.info);
        r_image = (ImageView) v.findViewById(R.id.r_image);
        modes = (ImageView) v.findViewById(R.id.game_mode);
        final RelativeLayout r_info = (RelativeLayout) v.findViewById(R.id.r_info);
        final TextView in_1 = (TextView) v.findViewById(R.id.t_1);
        final TextView in_2 = (TextView) v.findViewById(R.id.t_2);

        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"battlelines.ttf");
        title.setTypeface(tf);
        in_1.setTypeface(tf);
        in_2.setTypeface(tf);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new Easy())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });

        med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new Medium())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new Hard())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });

        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    volume.setImageDrawable(getResources().getDrawable(R.drawable.ic_volume_off));
                    mp.pause();
                    isPlaying = false;
                    editor.putBoolean("MUSIC", false);
                    editor.commit();
                } else {
                    volume.setImageDrawable(getResources().getDrawable(R.drawable.ic_volume_on));
                    mp.start();
                    mp.setLooping(true);
                    mp.setVolume(100, 100);
                    isPlaying = true;
                    editor.putBoolean("MUSIC",true);
                    editor.commit();
                }
            }
        });

        if (!isPlaying) {
            volume.setImageDrawable(getResources().getDrawable(R.drawable.ic_volume_off));

        } else {
            volume.setImageDrawable(getResources().getDrawable(R.drawable.ic_volume_on));
        }

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new Rules())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });

        hscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new HighScore())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableButtons();
                r_image.setEnabled(true);
                r_image.setVisibility(View.VISIBLE);
                in_1.setVisibility(View.VISIBLE);
                in_2.setVisibility(View.VISIBLE);
                r_info.setVisibility(View.VISIBLE);
                r_info.startAnimation(anim_in);
            }
        });

        r_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableButtons();
                r_image.setEnabled(false);
                r_info.startAnimation(anim_out);
                r_image.setVisibility(View.INVISIBLE);
            }
        });

        modes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new GameModes())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });

        return v;
    }

    public void disableButtons(){
        easy.setEnabled(false);
        med.setEnabled(false);
        hard.setEnabled(false);
        hscore.setEnabled(false);
        volume.setEnabled(false);
        info.setEnabled(false);
        rate.setEnabled(false);
        rule.setEnabled(false);
    }

    public void enableButtons(){
        easy.setEnabled(true);
        med.setEnabled(true);
        hard.setEnabled(true);
        hscore.setEnabled(true);
        volume.setEnabled(true);
        info.setEnabled(true);
        rate.setEnabled(true);
        rule.setEnabled(true);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
        mp.release();
    }
}
