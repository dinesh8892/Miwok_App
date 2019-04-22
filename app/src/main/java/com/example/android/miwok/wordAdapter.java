package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class wordAdapter extends ArrayAdapter<word> {
    private int mcolorResourceid;
    public wordAdapter(Activity context, ArrayList<word> words, int color){
        super(context, 0, words);
        mcolorResourceid = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        word currentword = getItem(position);
        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.text1);
        miwokTranslation.setText(currentword.getMiwok_translation());
        TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.text2);
        defaultTranslation.setText(currentword.getDefault_translation());
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        if (currentword.hasImage()){
        image.setImageResource(currentword.getImageResourceId());
        image.setVisibility(View.VISIBLE);}
        else {
            image.setVisibility(View.GONE);
        }
        View textContainer = listItemView.findViewById(R.id.text_container);
        int mcolor = ContextCompat.getColor(getContext(), mcolorResourceid);
        textContainer.setBackgroundColor(mcolor);
        return listItemView;
    }
}
