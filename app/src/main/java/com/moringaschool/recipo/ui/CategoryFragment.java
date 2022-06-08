package com.moringaschool.recipo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.secure.foodycookbook.R;

public class CategoryFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_fragment);
    }

    public void setArguments(Bundle args) {
    }
}