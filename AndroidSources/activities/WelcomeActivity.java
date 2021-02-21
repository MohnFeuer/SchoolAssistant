package com.example.imoocmusicdemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.imoocmusicdemo.R;

import java.util.Timer;
import java.util.TimerTask;

//1.延迟3秒钟
//2.跳转页面
public class WelcomeActivity extends BaseActivity {

    private Timer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();
    }

    //初始化
    private void init() {
        mTimer = new Timer();

        //参数1 回调方法 参数2 延迟时间(ms)
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                //Log.e("WelcomeActivity","当前线程：");
//                toMain();
                toLogin();
            }
        }, 3 * 1000);
    }

    /**
     * 跳转到MainActivity
     */
    private void toMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 跳转到LoginActivity
     */
    private void toLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
