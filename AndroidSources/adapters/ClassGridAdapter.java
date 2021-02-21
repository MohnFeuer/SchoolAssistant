package com.example.imoocmusicdemo.adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.imoocmusicdemo.R;
import com.example.imoocmusicdemo.activities.school.ClassDetailActivity;
import com.example.imoocmusicdemo.activities.school.ClassTableActivity;
import com.example.imoocmusicdemo.entities.TableItem;

import java.util.List;

public class ClassGridAdapter extends RecyclerView.Adapter<ClassGridAdapter.ViewHolder> {

    private Context mContext;
    private List<TableItem> mList;

    //构造方法
    public ClassGridAdapter (Context context, List<TableItem> mList)
    {
        mContext = context;
        this.mList = mList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_grid_class, parent, false));
    }

    //控件赋值
    //负责将每个子项holder绑定数据
    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final TableItem tI = mList.get(position);
        if(position < 5)
        {

            holder.mTvClassName.setText(tI.getItemName());
            holder.mFlBg.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.mFlBg.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;

            holder.mTvClassId.setVisibility(View.GONE);
            holder.mTvClassLoc.setVisibility(View.GONE);
            holder.mTvClassTeacher.setVisibility(View.GONE);
        }
        else {
            if (tI.isShow()) {
                holder.mTvClassName.setText(tI.getItemName());
                holder.mTvClassId.setText(tI.getSpeclassId().toString());
                holder.mTvClassLoc.setText(tI.getItemLoc());
                holder.mTvClassTeacher.setText(tI.getTeacherId().toString());

            }
            else {
                holder.mTvClassName.setVisibility(View.INVISIBLE);
                holder.mTvClassLoc.setVisibility(View.INVISIBLE);
            }

            //position>5 点击时跳转到classDetailActivity
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ClassDetailActivity.class);
                    intent.putExtra(ClassDetailActivity.SP_ID, tI.getSpeclassId().toString());
                    intent.putExtra(ClassDetailActivity.TEA_ID, tI.getTeacherId().toString());
                    intent.putExtra(ClassDetailActivity.CNAME, tI.getItemName());
                    mContext.startActivity(intent);
                }
            });
        }


        //position<5时点击无反应
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    //初始化控件
    class ViewHolder extends RecyclerView.ViewHolder {

        View itemView;
        TextView mTvClassLoc, mTvClassName, mTvClassTeacher, mTvClassId;
        FrameLayout mFlBg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.itemView = itemView;
            mFlBg = itemView.findViewById(R.id.fl_bg);
            mTvClassLoc = itemView.findViewById(R.id.tv_class_loc);
            mTvClassName = itemView.findViewById(R.id.tv_class_name);
            mTvClassTeacher = itemView.findViewById(R.id.tv_class_teacher);
            mTvClassId = itemView.findViewById(R.id.tv_class_id);
        }

    }


}
