package com.moringaschool.recipo.network;

import com.moringaschool.recipo.models.Categories;
import com.moringaschool.recipo.models.Meals;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.moringaschool.recipo.models.Search;


public interface FoodApi {
    @GET("random.php")
    Call<Meals> getMeal();

    @GET("categories.php")
    Call<Categories> getCategories();

    @GET("filter.php")
    Call<Meals> getMealByCategory(@Query("c") String category);

    @GET("search.php")
    Call<Meals> getMealByName(@Query("s") String mealName);
}
//
//import com.moringaschool.recipo.models.Categories;
//import com.moringaschool.recipo.models.Meals;
//
//import retrofit2.Call;
//import retrofit2.http.GET;
//import retrofit2.http.Query;
//
//
//public interface FoodApi {
//    @GET("random.php")
//    Call<Meals> getMeal();
//
//    @GET("categories.php")
//    Call<Categories> getCategories();
//
//    @GET("filter.php")
//    Call<Meals> getMealByCategory(@Query("c") String category);
//
//    @GET("search.php")
//    Call<Meals> getMealByName(@Query("s") String mealName);
//}