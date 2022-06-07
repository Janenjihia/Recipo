package com.moringaschool.recipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeActivity extends AppCompatActivity {
    @BindView(R.id.introTextView) TextView mIntroTextView;
    @BindView(R.id.listView) ListView mListView;


    private String[] recipes = new String[]{"Chicken Curry", "Pasta", "Fried Beef", "mixed veg Rice",
            "Chinese rice", "Meat roll", "Pilau", "Tuna", "Mashed potatoes", "Pizza", " Mixed veges", "baked beans",
            "Beef Tacos", "grilled chicken"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);



        mListView = (ListView) findViewById(R.id.listView);
        mIntroTextView = (TextView) findViewById(R.id.introTextView);

        mListView = (ListView) findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, recipes);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(RecipeActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });

        mIntroTextView = (TextView) findViewById(R.id.introTextView);
        Intent intent = getIntent();
        String intro = intent.getStringExtra("intro");
        mIntroTextView.setText("Here are all the recipes for: " + intro);
    }
}