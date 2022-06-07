package com.moringaschool.recipo;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class MyRecipeArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRecipes;
    private String[] mServings;

    public MyRecipeArrayAdapter(Context mContext, int resource, String[] mRecipes, String[] mServings) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mRecipes = mRecipes;
        this.mServings = mServings;
    }


    @Override
    public Object getItem(int position) {
        String restaurant = mRecipes[position];
        String cuisine = mServings[position];
        return String.format("%s \nServes great: %s", restaurant, cuisine);
    }

    @Override
    public int getCount() {
        return mRecipes.length;
    }
}
