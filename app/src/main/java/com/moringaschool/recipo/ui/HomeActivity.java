package com.moringaschool.recipo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.recipo.Constants;
import com.moringaschool.recipo.adapter.RecyclerViewHomeAdapter;
import com.moringaschool.recipo.adapter.ViewPagerHeaderAdapter;
import com.moringaschool.recipo.models.Categories;
import com.moringaschool.recipo.models.Meals;
import com.moringaschool.recipo.utils.Utils;
import com.secure.foodycookbook.R;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeActivity extends AppCompatActivity implements HomeView {
    private DatabaseReference mSearchedRecipeReference;
    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_POSITION = "position";
    public static final String EXTRA_DETAIL = "detail";
    private FirebaseAuth mAuth;


    @BindView(R.id.view_pager_header)
    ViewPager viewPagerMeal;
    @BindView(R.id.recycler_category)
    RecyclerView recyclerViewCategory;

    HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAuth = FirebaseAuth.getInstance();
        ButterKnife.bind(this);


        mSearchedRecipeReference = FirebaseDatabase
                .getInstance()
                .getReferenceFromUrl("https://recipo-a24d9-default-rtdb.firebaseio.com");

        mSearchedRecipeReference.addValueEventListener(new ValueEventListener() { //attach listener

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) { //something changed!
                for (DataSnapshot recipeSnapshot : dataSnapshot.getChildren()) {
                    String recipe = recipeSnapshot.getValue().toString();
                    Log.d("recipes updated", "recipe: " + recipe); //log
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { //update UI here if error occurred.

            }
        });

        presenter = new HomePresenter(this);
        presenter.getMeals();
        presenter.getCategories();
    }

    @Override

    public void onStart(){

        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser==null)

        { startActivity(new Intent(HomeActivity.this, LoginActivity.class));

        } }

//    public void logout() {
//
//        FirebaseAuth.getInstance().signOut();
//
//        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
//
//    }

    @Override
    public void showLoading() {
        findViewById(R.id.shimmer_meal).setVisibility(View.VISIBLE);
        findViewById(R.id.shimmer_category).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        findViewById(R.id.shimmer_meal).setVisibility(View.GONE);
        findViewById(R.id.shimmer_category).setVisibility(View.GONE);
    }

    @Override
    public void setMeal(List<Meals.Meal> meal) {
        ViewPagerHeaderAdapter headerAdapter = new ViewPagerHeaderAdapter(meal, this);
        viewPagerMeal.setAdapter(headerAdapter);
        viewPagerMeal.setPadding(40, 0, 40, 0);
        headerAdapter.notifyDataSetChanged();

        headerAdapter.setOnItemClickListener(new ViewPagerHeaderAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                TextView mealName = view.findViewById(R.id.mealName);
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra(EXTRA_DETAIL, mealName.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void setCategory(final List<Categories.Category> category) {
        RecyclerViewHomeAdapter homeAdapter = new RecyclerViewHomeAdapter(category, this);
        recyclerViewCategory.setAdapter(homeAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3,
                GridLayoutManager.VERTICAL, false);
        recyclerViewCategory.setLayoutManager(layoutManager);
        recyclerViewCategory.setNestedScrollingEnabled(true);
        homeAdapter.notifyDataSetChanged();

        homeAdapter.setOnItemClickListener(new RecyclerViewHomeAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
                intent.putExtra(EXTRA_CATEGORY, (Serializable) category);
                intent.putExtra(EXTRA_POSITION, position);
                HomeActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this, "Title", message);
    }
}
