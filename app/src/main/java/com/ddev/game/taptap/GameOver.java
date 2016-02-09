package com.ddev.game.taptap;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Danish Shah on 27/01/2016.
 */
public class GameOver extends AppCompatActivity {

    long hscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);

        final SharedPreferences sPref = this.getSharedPreferences("TapTap!", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sPref.edit();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        long score = bundle.getLong("KEY_SCORE");
        Log.d("APP", "GOT Score" + score);
        if (score > hscore) {
            editor.putLong("HighScore", score);
            editor.commit();
        }

        hscore = sPref.getLong("HighScore", 0);


        Typeface tf = Typeface.createFromAsset(getAssets(), "battlelines.ttf");

        TextView sc = (TextView) findViewById(R.id.your_score);
        sc.setText(Long.toString(score));
        sc.setTypeface(tf);
        TextView hsc = (TextView) findViewById(R.id.high_score);
        hsc.setText(Long.toString(hscore));
        hsc.setTypeface(tf);
        TextView share = (TextView) findViewById(R.id.share_text);
        share.setTypeface(tf);

        ImageView replay = (ImageView) findViewById(R.id.replay);
        ImageView fb = (ImageView) findViewById(R.id.facebook);
        ImageView gp = (ImageView) findViewById(R.id.google_plus);
        ImageView twitt = (ImageView) findViewById(R.id.twitter);

        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(GameOver.this, MainActivity.class);
                startActivity(main);

                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                finish();
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        gp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        twitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
