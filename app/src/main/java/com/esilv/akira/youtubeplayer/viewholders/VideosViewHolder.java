package com.esilv.akira.youtubeplayer.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.esilv.akira.youtubeplayer.R;
import com.esilv.akira.youtubeplayer.models.Video;
import com.esilv.akira.youtubeplayer.interfaces.OnVideoSelectedListener;

/**
 * Created by AkiraQuenot on 22/03/2017.
 */

public class VideosViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView description;
    private OnVideoSelectedListener onVideoSelectedListener;

    public VideosViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
    }

    public void bind(final Video video) {
        title.setText(video.getTitle());
        description.setText(video.getDescription());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onVideoSelectedListener == null) {
                    return;
                }
                onVideoSelectedListener.onVideoSelected(video);
            }
        });
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }

}
