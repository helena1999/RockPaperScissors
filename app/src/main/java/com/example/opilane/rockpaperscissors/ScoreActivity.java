package com.example.opilane.rockpaperscissors;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView skoor;
    int lastscore;
    int best1,best2,best3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        skoor = findViewById(R.id.skoor);
        //load old scores
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        lastscore = preferences.getInt("lastScore", 0);
        best1 = preferences.getInt("best1", 0);
        best2 = preferences.getInt("best2", 0);
        best3 = preferences.getInt("best3", 0);
        //replace if there is a high score
        if (lastscore > best3){
            best3 = lastscore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3);
            editor.apply();
        }
        if (lastscore > best2){
            int temp = best2;
            best2 = lastscore;
            best3 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3);
            editor.putInt("best2",best2);
            editor.apply();

        }
        if (lastscore > best1){
            int temp = best1;
            best1 = lastscore;
            best2 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best2", best2);
            editor.putInt("best1",best1);
            editor.apply();
        }
        skoor.setText("LAST SCORE: " + lastscore + "\n" + "BEST 1:" + best1 + "\n" + "BEST 2:" + best2+ "\n" + "BEST 3:" + best3);
    }
        //display score



    public void again(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void start(View view) {
        Intent intent = new Intent (ScoreActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }
}
