package com.example.imoocmusicdemo.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;

import com.example.imoocmusicdemo.R;

//用于描述所有activity的共性
public class BaseActivity extends Activity {


    private ImageView mIvBack, mIvMe;
    private TextView mTvTitle;


    //封装方法，简化方法(find view by id)，返回继承view
    //接受资源文件的id，返回t 资源文件的子类
    protected <T extends View> T fd (@IdRes int id) {
        return findViewById(id);
    }


    /**
     * 初始化 navigation
     * @param isShowBack 显示返回
     * @param title 标题
     * @param isShowMe 显示个人中心
     */
    protected void initNavBar (boolean isShowBack, String title, boolean isShowMe) {

        mIvBack = fd(R.id.iv_back);
        mTvTitle = fd(R.id.tv_title);
        mIvMe = fd(R.id.iv_me);

        //根据参数判定是否显示部件
        mIvBack.setVisibility(isShowBack ? View.VISIBLE : View.GONE);
        mIvMe.setVisibility(isShowMe ? View.VISIBLE : View.GONE);
        mTvTitle.setText(title);

        //点击back，执行后退操作
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        mIvMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this, MeActivity.class));
            }
        });
    }
}
