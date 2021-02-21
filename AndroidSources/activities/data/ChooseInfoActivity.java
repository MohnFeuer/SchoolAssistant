package com.example.imoocmusicdemo.activities.data;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.imoocmusicdemo.R;
import com.example.imoocmusicdemo.activities.BaseActivity;
import com.example.imoocmusicdemo.activities.MainActivity;


public class ChooseInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_info);

        initView();
    }


    private void initView () {
        initNavBar(false, "选择", false);
    }

    public void onBookClick (View v) {
        //跳转到book页
        Intent intent = new Intent(this, BookActivity.class);
        startActivity(intent);
        //finish();
    }

    public void onExamClick (View v) {
        //跳转到exam页
        Intent intent = new Intent(this, ExamActivity.class);
        startActivity(intent);
        //finish();
    }

    public void onContestClick (View v) {
        //跳转到contest页
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //finish();
    }
}
