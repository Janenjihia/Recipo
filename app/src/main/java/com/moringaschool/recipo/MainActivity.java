package com.moringaschool.recipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.searchRecipeButton) Button mSearchRecipeButton;
    @BindView(R.id.introEditText) EditText mIntroEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchRecipeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSearchRecipeButton) {
            String intro = mIntroEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
            intent.putExtra("intro", intro);
            startActivity(intent);
        }
    }
}