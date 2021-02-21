package com.example.imoocmusicdemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imoocmusicdemo.MyApplication;
import com.example.imoocmusicdemo.R;
import com.example.imoocmusicdemo.utils.UserUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

import okhttp3.Call;

public class MeActivity extends BaseActivity {

    private MyApplication mApp;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        initView();
    }

    private void initView() {


        initNavBar(true, "个人中心",false);



        mApp= (MyApplication) getApplication();
        TextView textView = findViewById(R.id.tv_identity);
        textView.setText(mApp.getStudent().getStudentName());

        iv = findViewById(R.id.iv_icon);
        OkHttpUtils.get().url(mApp.getStudent().getStudentIcon()).build().execute(new BitmapCallback() {

            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(final Bitmap bitmap, int i) {

                //在UI线程中执行，否则onResponse是子线程
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iv.setImageBitmap(bitmap);
                    }
                });
            }

        });


        TextView textView1 = findViewById(R.id.tv_major);
        //textView1.setText(mApp.getStudent().getMajorId().toString());

    }

    /**
     * 修改密码点击事件
     */
    public void onChangeClick (View v) {
        startActivity(new Intent(this, ChangePasswordActivity.class));
    }

    /**
     * 退出登录
     */
    public void onLogoutClick (View v) {
        UserUtils.logout(this);
    }
}
