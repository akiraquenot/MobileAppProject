package com.esilv.akira.youtubeplayer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.esilv.akira.youtubeplayer.R;

public class SearchActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText = (EditText) findViewById(R.id.search_editText);
        button = (Button) findViewById(R.id.search_button);
        button.setOnClickListener(new onClickSearch());
    }

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent videoListIntent = new Intent(SearchActivity.this, ResultsActivity.class);
            videoListIntent.putExtra("request", editText.getText().toString());
            SearchActivity.this.startActivity(videoListIntent);
        }
    });

    private class onClickSearch implements View.OnClickListener{
        @Override
        public void onClick(View v){
            Intent goOnResultActivity = new Intent(SearchActivity.this, ResultsActivity.class);
            goOnResultActivity.putExtra("query", editText.getText().toString());
            SearchActivity.this.startActivityForResult(goOnResultActivity, REQUEST_CODE);
        }
    }

}
