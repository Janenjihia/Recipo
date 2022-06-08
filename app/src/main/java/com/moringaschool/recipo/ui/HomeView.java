package com.moringaschool.recipo.ui;

import com.moringaschool.recipo.models.Categories;
import com.moringaschool.recipo.models.Meals;

import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setMeal(List<Meals.Meal> meal);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);
}
