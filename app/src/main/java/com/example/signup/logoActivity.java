package com.example.signup;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
/*로고 화면*/
public class logoActivity extends Activity {
    Handler handler = new Handler();
    public SharedPreferences prefs;
    /*앱이 처음 동작하는지 체크하는 함수
        isFirstrun변수가 adb속에 파일로 저장되기 때문에,
         처음 동작여부 초기화 하려면 프로그램 실행시켜서 가상환경장치(adb)실행시킨뒤 device file explorer실행->data->data->com.example.signup->shared_prefs->pref.xml삭제*/
    public void checkFirstRun(){
        boolean isFirstRun = prefs.getBoolean("isFirstRun",true);
        if(isFirstRun == false){
            Intent newIntent = new Intent(getApplicationContext(),MainActivity.class);    //처음동작하지 않을경우 메인화면으로 이동
            startActivity(newIntent);
            finish();
        }else{
            Intent newIntent = new Intent(getApplicationContext(),termsActivity.class);   //처음동작할 경우 약관동의화면으로 이동
            startActivity(newIntent);
            finish();
        }
        prefs.edit().putBoolean("isFirstRun",false).apply();
    }
    Runnable r = new Runnable() {
        @Override
        public void run() {
            checkFirstRun();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intrologo);
        prefs = getSharedPreferences("Pref",MODE_PRIVATE);

    }
    @Override
    protected void onResume() {
        super.onResume();
// 다시 화면에 들어어왔을 때 예약 걸어주기
        handler.postDelayed(r, 1000); // 1초 뒤에 Runnable 객체 수행
    }

    @Override
    protected void onPause() {
        super.onPause();
// 화면을 벗어나면, handler 에 예약해놓은 작업을 취소하자
        handler.removeCallbacks(r); // 예약 취소
    }

}
