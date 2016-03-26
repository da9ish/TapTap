package com.ddev.game.taptap;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Danish Shah on 24/03/2016.
 */
public class GameOver extends Fragment {

    long hscore,cscore;
    int level;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.game_over, container, false);

        final SharedPreferences sPref = getContext().getSharedPreferences("TapTap!", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sPref.edit();

        switch (level){
            case 1:
                hscore = sPref.getLong("EHighScore",0);
                break;
            case 2:
                hscore = sPref.getLong("MHighScore",0);
                break;
            case 3:
                hscore = sPref.getLong("HHighScore",0);
                break;
        }
        Log.i("TapTap!", "Prev High Score is "+hscore);

        if (cscore > hscore) {
            switch (level){
                case 1:
                    editor.putLong("EHighScore", cscore);
                    editor.commit();
                    break;
                case 2:
                    editor.putLong("MHighScore", cscore);
                    editor.commit();
                    break;
                case 3:
                    editor.putLong("HHighScore", cscore);
                    editor.commit();
                    break;
            }
            hscore = cscore;
        }

        if(hscore==0)
            hscore=cscore;

        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "battlelines.ttf");

        TextView title = (TextView) v.findViewById(R.id.title);
        title.setTypeface(tf);
        TextView score = (TextView) v.findViewById(R.id.score);
        score.setTypeface(tf);
        TextView h = (TextView) v.findViewById(R.id.h_score);
        h.setTypeface(tf);
        TextView sc = (TextView) v.findViewById(R.id.curr_score);
        sc.setText(Long.toString(cscore));
        sc.setTypeface(tf);
        TextView hsc = (TextView) v.findViewById(R.id.high_score);
        hsc.setText(Long.toString(hscore));
        hsc.setTypeface(tf);

        ImageView replay = (ImageView) v.findViewById(R.id.replay);

        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (level){
                    case 1:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, new Easy())
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .commit();
                        break;
                    case 2:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, new Medium())
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .commit();
                        break;
                    case 3:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, new Hard())
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .commit();
                        break;
                }
            }
        });

        return v;
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("TapTap!", "OnStop.");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("TapTap!", "OnDestroyView.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getFragmentManager().beginTransaction()
                .remove(this)
                .commit();
        Log.i("TapTap!", "OnDestroy.");
    }

    public void setLevel(int l){
        level = l;
    }

    public void setCscore(long score){
        cscore = score;
    }
}
