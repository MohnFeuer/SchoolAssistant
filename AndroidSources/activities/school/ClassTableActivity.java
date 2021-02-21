package com.example.imoocmusicdemo.activities.school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.ClipData;
import android.os.Bundle;

import com.example.imoocmusicdemo.R;
import com.example.imoocmusicdemo.activities.BaseActivity;
import com.example.imoocmusicdemo.adapters.ClassGridAdapter;
import com.example.imoocmusicdemo.adapters.MusicGridAdapter;
import com.example.imoocmusicdemo.entities.Speclass;
import com.example.imoocmusicdemo.entities.TableItem;
import com.example.imoocmusicdemo.utils.HttpExecutor;
import com.example.imoocmusicdemo.utils.JsonParser;
import com.example.imoocmusicdemo.views.GSID2;
import com.example.imoocmusicdemo.views.GridSpaceItemDecoration;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ClassTableActivity extends BaseActivity {

    private RecyclerView mRvGrid;
    private ClassGridAdapter mGridAdapter;
    private List<Speclass> mSpeclassList;
    private List<TableItem> mTableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_table);

        initData();
        initView();
    }

    private void initData() {
        HttpExecutor httpExecutor = new HttpExecutor();
        JsonParser jsonParser = new JsonParser();
        try {
            mSpeclassList = jsonParser.json2speclass(httpExecutor.doPostSpeclass());
        } catch (InterruptedException | JSONException e) {
            e.printStackTrace();
        }
    }

    private void initView () {
        initNavBar(true, "我的课表", true);

        mTableList = Spe2Tab(mSpeclassList);
        mRvGrid = fd(R.id.rv_grid);  //mRvGrid就是recyclerView 网格布局控件

        //同一行展示5个元素
        mRvGrid.setLayoutManager(new GridLayoutManager(this, 5));
//        mRvGrid.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.albumMarginSize), mRvGrid));
        mRvGrid.addItemDecoration(new GSID2(getResources().getDimensionPixelSize(R.dimen.albumMarginSize), mRvGrid));
        mRvGrid.setNestedScrollingEnabled(false);  //设置内部不可以滑动，避免每次滑动让onBindHolder重新赋值造成错误

        mGridAdapter = new ClassGridAdapter(this, mTableList);
        mRvGrid.setAdapter(mGridAdapter);

    }


    /**
     * speclass的list转化为tableItem的List
     * @param speList
     * @return
     */
    private List<TableItem> Spe2Tab( List<Speclass> speList)
    {
        List<TableItem> list = new ArrayList<>();

        for (int i = 0; i < 25 ; i++)
        {

            TableItem tI = new TableItem();
            tI.setShow(false);

            if(i<5)
            {
                switch (i) {
                    case 0 :
                        tI.setItemName("星期一");
                        break;
                    case 1 :
                        tI.setItemName("星期二");
                        break;
                    case 2:
                        tI.setItemName("星期三");
                        break;
                    case 3:
                        tI.setItemName("星期四");
                        break;
                    case 4:
                        tI.setItemName("星期五");
                        break;
                }
            }

            list.add(tI);
        }

        //  对于spelist中每一个具体课程
        for(int i=0; i<speList.size(); i++)
        {
            //获取3个时间
            Integer cTime = speList.get(i).getSpeclassTime();
            for(int j=0; j < 3; j++)
            {
                //对于每一个时间，对应到在网格中的position
                int pos = cTime % 100;

                //pos不为0，则为list中的对应位置赋值
                if(pos != 0)
                {
                    list.get(pos-1).setShow(true);
                    list.get(pos-1).setSpeclassId(speList.get(i).getSpeclassId());
                    list.get(pos-1).setItemName(speList.get(i).getSpeclassName());
                    list.get(pos-1).setItemLoc(speList.get(i).getSpeclassLoc());
                    list.get(pos-1).setTeacherId(speList.get(i).getTeacherId());
                }
                cTime = cTime / 100;
            }
        }

        return list;
    }

}
