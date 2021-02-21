package com.example.imoocmusicdemo.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imoocmusicdemo.R;
import com.example.imoocmusicdemo.activities.school.ClassDetailActivity;
import com.example.imoocmusicdemo.entities.HomeWork;

import java.util.List;

public class ClassDetailAdapter extends RecyclerView.Adapter<ClassDetailAdapter.ViewHolder> {


    private Context mContext;
    private View mItemView;
    private RecyclerView mRv;
    private boolean isCalcaulationRvHeight;

    private List<HomeWork> mDataSource;

    //构造方法
    public ClassDetailAdapter (Context context, RecyclerView recyclerView, List<HomeWork> dataSource) {
            mContext = context;
            mRv = recyclerView;
            this.mDataSource = dataSource;
    }


    // 绑定布局
    @NonNull
    @Override
    public ClassDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            mItemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_homework, parent, false);  //获取单个元素
            return new ClassDetailAdapter.ViewHolder(mItemView);
    }

    // 加载数据
    @Override
    public void onBindViewHolder(@NonNull ClassDetailAdapter.ViewHolder holder, int position) {
            setRecyclerViewHeight();

            HomeWork homeWork = mDataSource.get(position);

            holder.tvTime.setText(homeWork.getHomeworkTime());
            holder.tvContent.setText(homeWork.getHomeworkInfo());

    }

    @Override
    public int getItemCount() {
            return mDataSource.size();
            }


    /**
     * 设置RV的高度
     * 1、获取ItemView的高度
     * 2、itemView的数量
     * 3、用itemViewHeight * itemViewNum = RecyclerView的高度
     */
    private void setRecyclerViewHeight () {

            if (isCalcaulationRvHeight || mRv == null) return;

            isCalcaulationRvHeight = true;

            //获取itemView的高度
            RecyclerView.LayoutParams itemViewLp = (RecyclerView.LayoutParams) mItemView.getLayoutParams();
            //获取itemView的数量
            int itemCount = getItemCount();
            // itemViewHeight * itemViewNum = RV的高度
            int recyclerViewHeight = itemViewLp.height * itemCount;
            //设置RV高度
            LinearLayout.LayoutParams rvLp = (LinearLayout.LayoutParams) mRv.getLayoutParams();
            rvLp.height = recyclerViewHeight;
            mRv.setLayoutParams(rvLp);
            }


    //  控件转换为对象
    class ViewHolder extends RecyclerView.ViewHolder {

        View itemView;
        TextView tvTime;
        TextView tvContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.itemView = itemView;  //item本身
            tvTime = itemView.findViewById(R.id.tv_homework_time);
            tvContent = itemView.findViewById(R.id.tv_homework_content);
        }
    }



}
