package com.moringaschool.recipo.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.recipo.R;

import butterknife.BindView;

public class SplashscreenActivity extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    ImageView image;
    TextView appnameview;
    private static int SPLASH_SCREEN = 5000;

    @BindView(R.id.appNameTextView)
    TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        image = findViewById(R.id.imageView);
        appnameview = findViewById(R.id.appNameTextView);
        image.setAnimation(topAnim);
        appnameview.setAnimation(topAnim);
        appnameview.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashscreenActivity.this, HomeActivity.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(image, "food_image");
                pairs[1] = new Pair<View, String>(appnameview, "app_name");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashscreenActivity.this, pairs);
                startActivity(intent);
            }
        }, 2000);
    }

}
