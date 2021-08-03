package com.cos.navex01.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.cos.navex01.MainActivity;
import com.cos.navex01.R;
import com.cos.navex01.SecondActivity;
import com.google.android.material.navigation.NavigationView;

public class NavigationViewHelper {
    private static final String TAG = "NavigationViewHelper";

    // 목적 : 리스너 등록
    public static void enableNavigation(Context context, NavigationView nav){


        nav.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_camera) {
                // 여기도 공통되는 부분이니까 쪼갤 수 있겠네
                intentSetting(context, MainActivity.class);
            }else if (item.getItemId() == R.id.nav_gallery) {
                intentSetting(context, SecondActivity.class);
            } else if (item.getItemId() == R.id.nav_tools) {

            }
            return true; // true 안하면 이벤트 발동이 안돼
        });
    }

    private static void intentSetting(Context context, Class activityClass){
        Intent intent = new Intent(
                context, // 내화면에서 내화면 가기
                activityClass // 얘는 어떻게 넘겨줄까??
        );
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}
