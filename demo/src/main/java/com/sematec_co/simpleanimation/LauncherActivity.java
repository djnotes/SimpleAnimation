package com.sematec_co.simpleanimation;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.github.constraintlayoutanimation.MyAnimation;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_launcher)
public class LauncherActivity extends AppCompatActivity{

    private final String LOG_TAG = LauncherActivity.class.getSimpleName();
    private MyAnimation mAnimation;

    @AfterViews
    void init () {
        mAnimation = MyAnimation.getInstance();
    }

    @ViewById
    Button start;

    @ViewById
    ConstraintLayout constraintLayout;

    @Click
    void start(){
        showAnimation();
    }



    private void showAnimation() {
        mAnimation.with(this).from(R.layout.second_keyframe)
                .animate(constraintLayout);
    }
}
