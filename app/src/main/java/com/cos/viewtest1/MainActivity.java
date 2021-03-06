package com.cos.viewtest1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.cos.viewtest1.util.IntentFlagSetting;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    private MainActivity mContext = this; // 항상 이렇게 쓰거라
    private Button btnMain;
    private Button btnTel;
    private IntentFlagSetting intentFlagSetting;

    // 안드로이드 생명주기
    @Override
    protected void onResume() { // onCreate - onResume 이 끝나야 그림이 그려지네!!!!
        Log.d(TAG, "onResume: " + MyData.data);

        if (MyData.data == null){
            MyData.data = getSharedData();
        }
        super.onResume();
       /* try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: " + MyData.data);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: " + MyData.data);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyData.data = "사과";
        initSharedData();

        Log.d(TAG, "onCreate: "+ MyData.data);

        init();
        initListener();
    }

    public void initSharedData(){
        // Shared - > io 일어남
        // 전역적인 정보를 여기 쓰면 좋음
        // intent 는
        SharedPreferences pref = getSharedPreferences("myData", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("data", "사과");
        // 꺼낼때는 pref.getString
    }

    public String getSharedData(){
        SharedPreferences pref = getSharedPreferences("myData", Activity.MODE_PRIVATE);
        return pref.getString("data", "");
    }

    private void init(){
        btnMain = findViewById(R.id.btnMain);
        btnTel = findViewById(R.id.btnTel);
    }

    private void initListener(){
        // 화면이동 해볼게
        btnMain.setOnClickListener(v -> {
            MyData.data = "딸기";
            Log.d(TAG, "initListener: MyData.data : " + MyData.data);
            // 엄청 자주 쓰이는 클래스 (얘가 그 트럭임)
            // Sub로 갔을 때 내 정보도 줬기 때문에 뒤로 가기 가능
            Intent intent = new Intent(
                    mContext,
                    SubActivity.class // 아직 메모리에 안떴어서 파일의 정보를 적어줘. 이 정보를 통해서 new 해줌
            );
            //intentFlagSetting.flagSetting(intent);
            //Log.d(TAG, "intent.getFlags(): " + intent.getFlags());


            intent.putExtra("myKey", "수박"); // 트럭에 싣고 감. 다음화면까지 감. 기본자료형만 됨!
            intent.putExtra("user", new User(1, "ssar", "1234"));
            //startActivity(intent); // 응답을 받지는 못함
            //startActivityForResult(intent, 1000); // -> 얘가 응답이 가능한 애
            activityResultLauncher.launch(intent);
            //Log.d(TAG, "initListener: activityResultLauncher : " + );
          
        });
        btnTel.setOnClickListener(v -> {
            Intent intent = new Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:01055552222")
            );
            startActivity(intent);
        });
    }

    private ActivityResultLauncher activityResultLauncher = (
                registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        (ActivityResult result)->{
                            // 데이터 응답의 결과는 여기서 받으면 된다
                            String resultData = result.getData().getStringExtra("username");
                            Log.d(TAG, "result: " + resultData);
                        }
                )
            );



//    @Override // 콜백시켜줌 -> 온크리에이트가 또 실행 되지 않으니까 getIntent 할 수 없어
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        String username = data.getStringExtra("username");
//
//        Log.d(TAG, "onActivityResult: requestCode : " + requestCode);
//        Log.d(TAG, "onActivityResult: resultCode : " + resultCode);
//        Log.d(TAG, "onActivityResult: username : " + username);
//    }
}