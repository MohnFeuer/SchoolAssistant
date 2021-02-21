package com.example.imoocmusicdemo.activities.data;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imoocmusicdemo.R;
import com.example.imoocmusicdemo.activities.BaseActivity;
import com.example.imoocmusicdemo.adapters.BookListAdapter;
import com.example.imoocmusicdemo.adapters.ExamListAdapter;
import com.example.imoocmusicdemo.entities.Exam;
import com.example.imoocmusicdemo.utils.HttpExecutor;
import com.example.imoocmusicdemo.utils.JsonParser;

import org.json.JSONException;

import java.util.List;

public class ExamActivity extends BaseActivity {

    private RecyclerView mRvList;

    private ExamListAdapter mListAdapter;
    private List<Exam> mExamList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        initData();
        initView();
    }

    private void initData() {
        HttpExecutor httpExecutor = new HttpExecutor();
        JsonParser jsonParser = new JsonParser();
        try {
            mExamList = jsonParser.json2exam(httpExecutor.doGetExam());
        } catch (InterruptedException | JSONException e) {
            e.printStackTrace();
        }
    }

    private void initView () {
        initNavBar(true, "考试", true);

        /**
         *  1、假如已知列表高度的情况下，可以直接在布局中把recyclerview高度定义上
         *  2、不知道列表高度的情况下，需要手动计算recyclerview的高度
         */
        //寻找布局
        mRvList = fd(R.id.exam_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));  //recyclerview的布局
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // 初始化adpter，数据在此作为参数传入
        mListAdapter = new ExamListAdapter(this, mRvList, mExamList);
        mRvList.setAdapter(mListAdapter);
    }
}
