/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//import android.widget.ArrayAdapter;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<>();
        Log.i("in NumbersActivity", "color value: "+R.color.category_numbers);
        words.add(new Word(Color.parseColor("#FD8E09"), R.raw.number_one, R.drawable.number_one, "lutti", "one"));
        words.add(new Word(Color.parseColor("#FD8E09"), R.raw.number_two, R.drawable.number_two, "otiiko", "two"));
        words.add(new Word(Color.parseColor("#FD8E09"), R.raw.number_three, R.drawable.number_three, "tolookosu", "three"));
        words.add(new Word(Color.parseColor("#FD8E09"), R.raw.number_four, R.drawable.number_four, "oyyisa", "four"));
        words.add(new Word(Color.parseColor("#FD8E09"), R.raw.number_five, R.drawable.number_five, "massokka", "five"));
        words.add(new Word(Color.parseColor("#FD8E09"), R.raw.number_six, R.drawable.number_six, "temmokka", "six"));
        words.add(new Word(Color.parseColor("#FD8E09"), R.raw.number_seven, R.drawable.number_seven, "kenekaku", "seven"));
        words.add(new Word(Color.parseColor("#FD8E09"), R.raw.number_eight, R.drawable.number_eight, "kawinta", "eight"));
        words.add(new Word(Color.parseColor("#FD8E09"), R.raw.number_nine, R.drawable.number_nine, "wo’e", "nine"));
        words.add(new Word(Color.parseColor("#FD8E09"), R.raw.number_ten, R.drawable.number_ten, "na’aacha", "ten"));

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
        // words_list.xmlt file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
    }
}