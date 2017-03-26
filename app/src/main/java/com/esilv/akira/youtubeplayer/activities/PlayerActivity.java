package com.esilv.akira.youtubeplayer.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.esilv.akira.youtubeplayer.R;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
    }

    public static void start(ResultsActivity resultsActivity, String title) {
        //...
    }
}
