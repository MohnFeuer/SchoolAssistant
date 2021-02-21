package com.example.imoocmusicdemo.activities.school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.imoocmusicdemo.R;
import com.example.imoocmusicdemo.activities.BaseActivity;
import com.example.imoocmusicdemo.adapters.BookListAdapter;
import com.example.imoocmusicdemo.adapters.ClassDetailAdapter;
import com.example.imoocmusicdemo.entities.HomeWork;
import com.example.imoocmusicdemo.utils.HttpExecutor;
import com.example.imoocmusicdemo.utils.JsonParser;

import org.json.JSONException;

import java.util.List;

public class ClassDetailActivity extends BaseActivity {

    private RecyclerView mRvList;
    private TextView mTeaName;
    private TextView mSpeName;

    private ClassDetailAdapter mListAdapter;
    private String teacherName;
    private List<HomeWork> mHomeworkList;

    private static String speclassId, teacherId,speclassName;
    public static final String SP_ID = "speclassId";
    public static final String TEA_ID = "teacherId";
    public static final String CNAME = "speclassName";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_detail);

        initData();
        initView();
    }


    private void initData() {

        speclassId = getIntent().getStringExtra(SP_ID);
        teacherId = getIntent().getStringExtra(TEA_ID);
        speclassName = getIntent().getStringExtra(CNAME);

        HttpExecutor httpExecutor = new HttpExecutor();
        JsonParser jsonParser = new JsonParser();
        try {
            mHomeworkList = jsonParser.json2homework(httpExecutor.doPostHomework(speclassId));
            teacherName = jsonParser.json2tName(httpExecutor.doPostTeacher(teacherId));
        } catch (InterruptedException | JSONException e) {
            e.printStackTrace();
        }
    }

    private void initView () {
        initNavBar(true, "书籍", true);

        /**
         *  1、假如已知列表高度的情况下，可以直接在布局中把recyclerview高度定义上
         *  2、不知道列表高度的情况下，需要手动计算recyclerview的高度
         */
        //寻找布局
        mTeaName =fd(R.id.tv_class_teacher);
        mTeaName.setText(teacherName);

        mSpeName=fd(R.id.tv_class_name);
        mSpeName.setText(speclassName);

        mRvList = fd(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));  //recyclerview的布局
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // 初始化adpter，数据在此作为参数传入
        mListAdapter = new ClassDetailAdapter(this, mRvList, mHomeworkList);
        mRvList.setAdapter(mListAdapter);
    }
}
