package com.cos.viewtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    private static final String TAG = "SubActivity";

    private Button btnSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // main 처럼 intent 하면 쌓이니까 하면 안돼

        Intent intent = getIntent(); // 트럭에 바로 접근
        String data = intent.getStringExtra("myKey");
        User user = (User) intent.getSerializableExtra("user");
        Log.d(TAG, "onCreate: data : " + data);
        Log.d(TAG, "onCreate: username : " + user.getUsername());

        init();
        initListener();
    }

    public void init(){
        btnSub = findViewById(R.id.btnSub);
    }

    public void initListener(){
        btnSub.setOnClickListener(v -> {
            Log.d(TAG, "onCreate: MyData.data : " + MyData.data);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("username", "ssar");
            setResult(RESULT_OK, resultIntent); // 1000, -1, username : ssar
            finish(); // 나를 호출한 화면으로 데이터를 응답
        });
    }
}