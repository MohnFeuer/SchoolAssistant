package com.example.imoocmusicdemo.activities.data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.imoocmusicdemo.R;
import com.example.imoocmusicdemo.activities.BaseActivity;
import com.example.imoocmusicdemo.adapters.BookListAdapter;
import com.example.imoocmusicdemo.adapters.MusicGridAdapter;
import com.example.imoocmusicdemo.adapters.MusicListAdapter;
import com.example.imoocmusicdemo.entities.Book;
import com.example.imoocmusicdemo.utils.HttpExecutor;
import com.example.imoocmusicdemo.utils.JsonParser;
import com.example.imoocmusicdemo.views.GridSpaceItemDecoration;

import org.json.JSONException;

import java.util.List;

public class BookActivity extends BaseActivity {


    private RecyclerView mRvList;

    private BookListAdapter mListAdapter;
    private List<Book> mBookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initData();  //初始化数据
        initView();
    }

    private void initData() {
        HttpExecutor httpExecutor = new HttpExecutor();
        JsonParser jsonParser = new JsonParser();
        try {
            mBookList = jsonParser.json2book(httpExecutor.doGetBook());
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
        mRvList = fd(R.id.book_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));  //recyclerview的布局
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // 初始化adpter，数据在此作为参数传入
        mListAdapter = new BookListAdapter(this, mRvList, mBookList);
        mRvList.setAdapter(mListAdapter);
    }

}
