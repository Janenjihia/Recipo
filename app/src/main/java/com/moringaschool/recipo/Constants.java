package com.moringaschool.recipo;

import android.app.AlertDialog;
import android.content.Context;

import com.moringaschool.recipo.network.FoodApi;
import com.moringaschool.recipo.network.FoodClient;

public class Constants {
    public static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    public static final String FIREBASE_CHILD_SEARCHED_RECIPE= "https://recipo-a24d9-default-rtdb.firebaseio.com";

    public static FoodApi getApi() {
        return FoodClient.getFoodClient().create(FoodApi.class);
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message){
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }
}