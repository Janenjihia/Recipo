package com.moringaschool.recipo.dao;

import com.moringaschool.recipo.models.Meals;

public interface DetailView {
    void showLoading();
    void hideLoading();
    void setMeal(Meals.Meal meal);
    void onErrorLoading(String message);
}
