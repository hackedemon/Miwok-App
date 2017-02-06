package com.example.android.miwok;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(Color.parseColor("#16AFCA"), R.raw.phrase_where_are_you_going, "minto wuksus", "Where are you going?"));
        words.add(new Word(Color.parseColor("#16AFCA"), R.raw.phrase_what_is_your_name, "tinnә oyaase'nә", "What is your name?"));
        words.add(new Word(Color.parseColor("#16AFCA"), R.raw.phrase_my_name_is, "oyaaset...", "My name is..."));
        words.add(new Word(Color.parseColor("#16AFCA"), R.raw.phrase_how_are_you_feeling, "michәksәs?", "How are you feeling?"));
        words.add(new Word(Color.parseColor("#16AFCA"), R.raw.phrase_im_feeling_good, "kuchi achit", "I’m feeling good."));
        words.add(new Word(Color.parseColor("#16AFCA"), R.raw.phrase_are_you_coming, "әәnәs'aa?", "Are you coming?"));
        words.add(new Word(Color.parseColor("#16AFCA"), R.raw.phrase_yes_im_coming, "hәә’ әәnәm", "Yes, I’m coming."));
        words.add(new Word(Color.parseColor("#16AFCA"), R.raw.phrase_im_coming, "әәnәm", "I’m coming."));
        words.add(new Word(Color.parseColor("#16AFCA"), R.raw.phrase_lets_go, "yoowutis", "Let’s go."));
        words.add(new Word(Color.parseColor("#16AFCA"), R.raw.phrase_come_here, "әnni'nem", "Come here."));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
//        ArrayAdapter<Word> itemsAdapter =
//                new ArrayAdapter<Word>(this, R.layout.list_item, words);

        WordAdapter adapter = new WordAdapter(this, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // words_listayout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
    }
}
