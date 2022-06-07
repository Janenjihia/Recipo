package com.moringaschool.recipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {
    private TextView mIntroTextView;
    private ListView mListView;


    private String[] recipes = new String[]{"Chicken Curry", "Pasta", "Fried Beef", "mixed veg Rice",
            "Chinese rice", "Meat roll", "Pilau", "Tuna", "Mashed potatoes", "Pizza", " Mixed veges", "baked beans",
            "Beef Tacos", "grilled chicken"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, recipes);
        mListView.setAdapter(adapter);

        mIntroTextView = (TextView) findViewById(R.id.introTextView);
        Intent intent = getIntent();
        String intro = intent.getStringExtra("intro");
        mIntroTextView.setText("Here are all the recipes for: " + intro);
    }
}