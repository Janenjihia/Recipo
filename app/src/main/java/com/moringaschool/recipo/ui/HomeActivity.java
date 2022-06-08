package com.moringaschool.recipo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.moringaschool.recipo.dao.HomeView;
import com.secure.foodycookbook.R;


public class HomeActivity extends AppCompatActivity implements HomeView {
    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_POSITION = "position";
    public static final String EXTRA_DETAIL = "detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}

