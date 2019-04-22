package com.example.android.miwok;

import android.content.Context;

public class word {
    private String miwok_translation;
    private String default_translation;
    private int imageResourceId = NO_IMAGE_PROVIDED;
    private int audioResourceId;
    private static final int NO_IMAGE_PROVIDED = -1;
    // create a constructor
    public word(String defaultTranslation, String miwokTranslation, int audio) {
        default_translation = defaultTranslation;
        miwok_translation = miwokTranslation;
        audioResourceId = audio;
    }
    public word(String defaultTranslation, String miwokTranslation, int Image, int audio) {
        default_translation = defaultTranslation;
        miwok_translation = miwokTranslation;
        imageResourceId = Image;
        audioResourceId = audio;
    }
    // define getMiwok_translation method
    public String getMiwok_translation(){
        return miwok_translation;
    }
    public String getDefault_translation(){
        return default_translation;
    }
    public int getImageResourceId(){ return imageResourceId; }
    public int getAudioResourceId(){ return audioResourceId;}
    public boolean hasImage(){
        return imageResourceId != NO_IMAGE_PROVIDED;
    }
}
