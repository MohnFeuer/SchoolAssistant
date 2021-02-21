package com.example.imoocmusicdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imoocmusicdemo.R;
import com.example.imoocmusicdemo.activities.data.ChooseInfoActivity;
import com.example.imoocmusicdemo.activities.school.ClassTableActivity;
import com.example.imoocmusicdemo.adapters.MusicGridAdapter;
import com.example.imoocmusicdemo.adapters.MusicListAdapter;
import com.example.imoocmusicdemo.views.GridSpaceItemDecoration;

public class MainActivity extends BaseActivity {


    private RecyclerView mRvGrid, mRvList;
    private MusicGridAdapter mGridAdapter;
    private MusicListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initData() {

    }

    private void initView () {
        initNavBar(false, "校园助手", true);

    }

    public void onInfoClick (View v) {
        //跳转到info页
        Intent intent = new Intent(this, ChooseInfoActivity.class);
        startActivity(intent);
        //finish();  如果加上finish()就直接退出了
    }

    public void onTableClick (View v) {
        //跳转到classTable页
        Intent intent = new Intent(this, ClassTableActivity.class);
        startActivity(intent);
        //finish();  如果加上finish()就直接退出了
    }
}
