package com.esilv.akira.youtubeplayer.models;

/**
 * Created by AkiraQuenot on 22/03/2017.
 */

public class Video {
    String title;
    String description;

    public Video(String title) {
        this.title = title;
    }

    public Video(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
