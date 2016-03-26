package com.ddev.game.taptap;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Danish Shah on 24/03/2016.
 */
public class HighScore extends Fragment {

    long e,m,h;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.high_score, container, false);

        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "battlelines.ttf");
        SharedPreferences sPref = getContext().getSharedPreferences("TapTap!", Context.MODE_PRIVATE);

        e = sPref.getLong("EHighScore",0);
        m = sPref.getLong("MHighScore",0);
        h = sPref.getLong("HHighScore",0);

        ImageView home = (ImageView) v.findViewById(R.id.home);
        TextView title = (TextView) v.findViewById(R.id.title);
        TextView easy = (TextView) v.findViewById(R.id.easy);
        TextView med = (TextView) v.findViewById(R.id.med);
        TextView hard = (TextView) v.findViewById(R.id.hard);

        title.setTypeface(tf);
        easy.setTypeface(tf);
        med.setTypeface(tf);
        hard.setTypeface(tf);

        easy.setText("Easy : " + e);
        med.setText("Medium : " + m);
        hard.setText("Hard : " + h);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new Menu())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });

        return v;
    }
}
