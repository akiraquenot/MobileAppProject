package com.esilv.akira.youtubeplayer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.esilv.akira.youtubeplayer.Constants;
import com.esilv.akira.youtubeplayer.R;
import com.esilv.akira.youtubeplayer.adapters.VideosAdapter;
import com.esilv.akira.youtubeplayer.interfaces.OnVideoSelectedListener;
import com.esilv.akira.youtubeplayer.models.Video;
import com.esilv.akira.youtubeplayer.models.Videos;
import com.google.gson.Gson;

public class ResultsActivity extends AppCompatActivity implements OnVideoSelectedListener {

    private RecyclerView recyclerView;
    String keyword;
    String VIDEOS_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        keyword = intent.getStringExtra("query");
        VIDEOS_URL = "https://www.googleapis.com/youtube/v3/search?key=" + Constants.API_KEY + "&q="+ keyword + "&part=snippet";
        getVideos(VIDEOS_URL);
    }

    private void getVideos(String VIDEOS_URL) {
        StringRequest videosRequest = new StringRequest(VIDEOS_URL + "?apiKey=" + Constants.API_KEY, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //parse data from webservice to get Videos as Java object
                Videos videos = new Gson().fromJson(response, Videos.class);

                setAdapter(videos);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Contracts", "Error");
            }
        });
        Volley.newRequestQueue(this).add(videosRequest);
    }

    private void setAdapter(Videos videos) {
        VideosAdapter adapter = new VideosAdapter(videos);
        adapter.setOnVideoSelectedListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onVideoSelected(Video video) {
        PlayerActivity.start(this, video.getTitle());
    }
}
