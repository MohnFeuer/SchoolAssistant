package com.example.imoocmusicdemo.views;

import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int mSpace;

    public GridSpaceItemDecoration (int space, RecyclerView parent) {
        mSpace = space;
        getRecyclerViewOffsets(parent);
    }

    /**
     * 设置每个itemview 的偏移量
     * @param outRect item矩形边界
     * @param view itemView 本身
     * @param parent RecyclerView
     * @param state RecyclerView 的状态
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        //距离左侧有一个距离
        outRect.left = mSpace;

        //判断Item是不是每一行第一个Item
//        if (parent.getChildLayoutPosition(view) % 3 == 0) {
//            outRect.left = 0;
//        }


    }


    private void getRecyclerViewOffsets (RecyclerView parent) {
        //View margin，
        //margin为正，则View距离边界产生一个距离
        //margin为负，则View会超出边界，产生一个距离
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) parent.getLayoutParams();
        layoutParams.leftMargin = -mSpace;
        parent.setLayoutParams(layoutParams);


    }
}
