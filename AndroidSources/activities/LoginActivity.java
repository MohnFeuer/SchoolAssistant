package com.example.imoocmusicdemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.imoocmusicdemo.MyApplication;
import com.example.imoocmusicdemo.R;
import com.example.imoocmusicdemo.entities.Student;
import com.example.imoocmusicdemo.utils.UserUtils;
import com.example.imoocmusicdemo.views.InputView;

import org.json.JSONException;

import okhttp3.OkHttpClient;

public class LoginActivity extends BaseActivity {

    private InputView mInputPhone, mInputPassword;

    //用来为全局变量赋值
    private MyApplication mApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    /**
     * 初始化view
     */
    private void initView () {
        initNavBar(false, "登录", false);

        mInputPhone = fd(R.id.input_phone);
        mInputPassword = fd(R.id.input_password);
    }


    /**
     * 跳转注册页面点击事件
     * @param view
     */
    public void onRegisterClick (View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    /**
     * 登录
     * @param v
     */
    public void onCommitClick (View v) throws JSONException, InterruptedException {
        String phone = mInputPhone.getInputStr();
        String password = mInputPassword.getInputStr();

        Student student = new Student();
        student = UserUtils.validateLogin(this, phone, password);
        //验证用户输入是否合法
        if(student == null) {
            return;
        }

        mApp= (MyApplication) getApplication();
        mApp.setStudent(student);

        //跳转到应用主页
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
