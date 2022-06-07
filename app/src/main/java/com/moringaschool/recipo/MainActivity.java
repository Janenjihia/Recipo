package com.moringaschool.recipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mSearchRecipeButton;
    private EditText mIntroEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntroEditText = (EditText) findViewById(R.id.introEditText);
        mSearchRecipeButton = (Button)findViewById(R.id.searchRecipeButton);
        mSearchRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String intro = mIntroEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
                intent.putExtra("intro", intro);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Welcome to Recipo", Toast.LENGTH_LONG).show();
            }
        });
    }
}