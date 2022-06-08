package com.moringaschool.recipo.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class FoodApi {
    @GET("random.php")
    public Call<Meals> getMeal() {
        return null;
    }

    @GET("categories.php")
    public Call<Categories> getCategories() {
        return null;
    }

    @GET("filter.php")
    public Call<Meals> getMealByCategory(@Query("c") String category) {
        return null;
    }

    @GET("search.php")
    public Call<Meals> getMealByName(@Query("s") String mealName) {
        return null;
    }
}
