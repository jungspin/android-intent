package com.cos.navex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.cos.navex01.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    private Context mContext = MainActivity.this; // 전역으로 걸면 안전하게 쓸 수 있음
    private NavigationView nav;
    //private MenuItem navCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initListener();
    }

    public void init(){
        nav = findViewById(R.id.nav);
        //navCamera = findViewById(R.id.nav_camera);
    }

    public void initListener(){
        // 공통적으로 만들어야돼
        NavigationViewHelper.enableNavigation(mContext, nav, SecondActivity.class);


    }
}