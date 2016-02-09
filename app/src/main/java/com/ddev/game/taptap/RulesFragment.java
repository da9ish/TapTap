package com.ddev.game.taptap;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Home on 30/01/2016.
 */
public class RulesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rule, container, false);

        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "battlelines.ttf");
        TextView rule = (TextView) v.findViewById(R.id.rule);
        rule.setTypeface(tf);

        return v;
    }
}
