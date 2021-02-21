package com.example.imoocmusicdemo.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imoocmusicdemo.R;
import com.example.imoocmusicdemo.activities.data.ExamActivity;
import com.example.imoocmusicdemo.entities.Exam;

import java.util.List;

public class ExamListAdapter extends RecyclerView.Adapter<ExamListAdapter.ViewHolder> {

    private Context mContext;
    private View mItemView;
    private RecyclerView mRv;
    private boolean isCalcaulationRvHeight;
    private List<Exam> mDataSource;

    //构造方法
    public ExamListAdapter (Context context, RecyclerView recyclerView, List<Exam> dataSource) {
        mContext = context;
        mRv = recyclerView;
        this.mDataSource = dataSource;
    }


    // 绑定布局
    @NonNull
    @Override
    public ExamListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mItemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_exam, parent, false);  //获取单个元素
        return new ExamListAdapter.ViewHolder(mItemView);
    }

    // 加载数据
    @Override
    public void onBindViewHolder(@NonNull ExamListAdapter.ViewHolder holder, int position) {
        setRecyclerViewHeight();

        Exam exam = mDataSource.get(position);

        holder.tvName.setText(exam.getExamName());
        holder.tvInfo.setText(exam.getExamInfo());
        holder.tvTime.setText(exam.getExamTime());

        //进入书籍详情界面
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ExamActivity.class);
                mContext.startActivity(intent);
            }
        });
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
        TextView tvInfo;
        TextView tvName;
        TextView tvTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.itemView = itemView;  //item本身
            tvInfo = itemView.findViewById(R.id.tv_info);
            tvName = itemView.findViewById(R.id.tv_name);
            tvTime = itemView.findViewById(R.id.tv_time);
        }
    }


}
