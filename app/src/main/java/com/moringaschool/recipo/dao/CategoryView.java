package com.moringaschool.recipo.dao;

import com.moringaschool.recipo.models.Meals;

import java.util.List;

public interface CategoryView {
    void showLoading();
    void hideLoading();
    void setMeals(List<Meals.Meal> meals);
    void onErrorLoading(String message);
}
