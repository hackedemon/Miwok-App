package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chirag on 01-02-2017.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> word) {
        super(context, 0, word);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current Word object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current Word object and
        // set this text on the number TextView
        numberTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.the_image_view);
        // Get the image resource ID from the current Word object and
        // set the image to iconView
//        Log.i("in WordAdapter","value of currentWord.getImageView"+currentWord.getImageView());
        iconView.setImageResource(currentWord.getImageView());
        if (currentWord.getImageView() == 0) {
            iconView.getLayoutParams().width = 0;
        }

        LinearLayout textLayout = (LinearLayout) listItemView.findViewById(R.id.list_item_layout);
        textLayout.setBackgroundColor(currentWord.getBackgroundColor());

        final MediaPlayer song = MediaPlayer.create(getContext(), currentWord.getSongId());
        textLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (song.isPlaying())
                    song.pause();
                else
                    song.start();
            }
        });
//        Log.i("in WordAdapter","backgroundColor value: "+currentWord.getBackgroundColor());

        // Return the whole list item layout (containing 2 TextViews and an ImageView and a LinearLayout)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
