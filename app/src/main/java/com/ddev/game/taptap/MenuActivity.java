package com.ddev.game.taptap;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Danish Shah on 27/01/2016.
 */
public class MenuActivity extends AppCompatActivity {

    public static boolean isPlaying;
    public boolean music;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final SharedPreferences sPref = this.getSharedPreferences("TapTap!",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sPref.edit();


        music = sPref.getBoolean("MUSIC", true);
        isPlaying = music;
        mp = MediaPlayer.create(this, R.raw.back_music);
        if(music) {
            mp.start();
            mp.setLooping(true);
            mp.setVolume(100, 100);
        }

        TextView title = (TextView) findViewById(R.id.title);
        final ImageView volume = (ImageView) findViewById(R.id.volume);
        ImageView rate = (ImageView) findViewById(R.id.rate);
        ImageView rule = (ImageView) findViewById(R.id.rule);
        ImageView play = (ImageView) findViewById(R.id.replay);
        //TextView easy = (TextView) findViewById(R.id.easy);
        //TextView med = (TextView) findViewById(R.id.med);
        //TextView hard = (TextView) findViewById(R.id.hard);

        Typeface tf = Typeface.createFromAsset(getAssets(),"battlelines.ttf");
        title.setTypeface(tf);
        //easy.setTypeface(tf);
        //med.setTypeface(tf);
        //hard.setTypeface(tf);

        /*hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(main);

                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });*/

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(main);

                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
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
                Fragment rule = new RulesFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, rule)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
        mp.release();
    }
}
