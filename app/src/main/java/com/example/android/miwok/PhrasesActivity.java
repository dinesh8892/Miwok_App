package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer phrasePlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        final ArrayList<word> words = new ArrayList<>();
        words.add(new word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        words.add(new word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        words.add(new word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new word("Come here.", "әnni'nem", R.raw.phrase_come_here));
        wordAdapter adapter = new wordAdapter(this, words, R.color.category_phrases);

        ListView listview = (ListView) findViewById(R.id.list);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                word phraseaudio = words.get(position);
                releaseMediaPlayer();
                phrasePlayer = MediaPlayer.create(PhrasesActivity.this, phraseaudio.getAudioResourceId());
                phrasePlayer.start();
                phrasePlayer.setOnCompletionListener(mCompletionListener);

            }
        });
    }
    private void releaseMediaPlayer(){
        if(phrasePlayer != null){
            phrasePlayer.release();
            phrasePlayer = null;
        }

    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
