package com.esilv.akira.youtubeplayer.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esilv.akira.youtubeplayer.R;
import com.esilv.akira.youtubeplayer.interfaces.OnVideoSelectedListener;
import com.esilv.akira.youtubeplayer.models.Videos;
import com.esilv.akira.youtubeplayer.viewholders.VideosViewHolder;

/**
 * Created by AkiraQuenot on 22/03/2017.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosViewHolder> {

    private final Videos videos;
    private OnVideoSelectedListener onVideoSelectedListener;

    public VideosAdapter(Videos videos) {
        this.videos = videos;
    }

    @Override
    public VideosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_result, parent, false);
        return new VideosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideosViewHolder holder, int position) {
        holder.setOnVideoSelectedListener(onVideoSelectedListener);
        holder.bind(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos != null ? videos.size() : 0;
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}