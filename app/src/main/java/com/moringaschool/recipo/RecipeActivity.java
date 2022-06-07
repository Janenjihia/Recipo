package com.moringaschool.recipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {
    private TextView mIntroTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        mIntroTextView = (TextView) findViewById(R.id.introTextView);
        Intent intent = getIntent();
        String intro = intent.getStringExtra("intro");
        mIntroTextView.setText("Here are all the recipes for: " + intro);
    }
}