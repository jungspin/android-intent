package com.cos.navex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.cos.navex01.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    private Context mContext = SecondActivity.this;
    private NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        init();
        initListener();
    }

    public void init(){
        nav = findViewById(R.id.nav); // second의 nav임
        //navCamera = findViewById(R.id.nav_camera);
    }

    public void initListener(){
        // 공통적으로 만들어야돼
        NavigationViewHelper.enableNavigation(mContext, nav, MainActivity.class);;

    }
}