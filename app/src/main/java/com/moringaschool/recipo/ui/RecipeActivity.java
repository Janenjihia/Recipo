package com.moringaschool.recipo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.recipo.MyRecipeArrayAdapter;
import com.moringaschool.recipo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeActivity extends AppCompatActivity {
    @BindView(R.id.introTextView) TextView mIntroTextView;
    @BindView(R.id.listView) ListView mListView;


    private String[] recipes = new String[]{"Chicken Curry", "Pasta", "Fried Beef", "mixed veg Rice",
            "Chinese rice", "Meat roll", "Pilau", "Tuna", "Mashed potatoes", "Pizza", " Mixed veges", "baked beans",
            "Beef Tacos", "grilled chicken"};
    private String[] servings = new String[] {"2", "5", "6", "8","5","1", "4","9","6","2", "5", "3","4","7"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);

//        mListView = (ListView) findViewById(R.id.listView);
//        mIntroTextView = (TextView) findViewById(R.id.introTextView);
//
//        mListView = (ListView) findViewById(R.id.listView);

        MyRecipeArrayAdapter adapter = new MyRecipeArrayAdapter(this, android.R.layout.simple_list_item_1, recipes, servings);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String recipe = ((TextView)view).getText().toString();
                Toast.makeText(RecipeActivity.this, recipe, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String intro = intent.getStringExtra("intro");
        mIntroTextView.setText("Here are all the recipes for: " + intro);
    }
}