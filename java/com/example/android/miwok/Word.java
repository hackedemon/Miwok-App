package com.example.android.miwok;

import android.util.Log;

/**
 * Created by Chirag on 30-01-2017.
 */
public class Word {

    private String miwokTranslation;
    private String defaultTranslation;
    private int imageView;
    private int backgroundColor;
    private int songId;

    public Word (int backgroundColor, int songId, int imageView, String miwok_translation, String default_translation) {
        this.imageView = imageView;
        this.miwokTranslation = miwok_translation;
        this.defaultTranslation = default_translation;
        this.backgroundColor= backgroundColor;
        this.songId = songId;
    }

    public Word (int backgroundColor, int songId, String miwok_translation, String default_translation) {
        this.miwokTranslation = miwok_translation;
        this.defaultTranslation = default_translation;
        this.backgroundColor= backgroundColor;
        this.songId = songId;
    }

    public int getImageView() {
        return imageView;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getSongId() {
        return songId;
    }
}
