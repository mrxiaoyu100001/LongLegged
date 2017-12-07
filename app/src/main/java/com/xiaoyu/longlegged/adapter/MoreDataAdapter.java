package com.xiaoyu.longlegged.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaoyu.longlegged.R;
import com.xiaoyu.longlegged.modle.MoreData;
import com.xiaoyu.longlegged.utils.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created: xiaoyu  on 2017.12.07 21:18.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.07 21:18.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class MoreDataAdapter extends RecyclerView.Adapter<MoreDataAdapter.Hodler> {

    private List<MoreData> data;

    public MoreDataAdapter() {
    }

    public void refresh(List<MoreData> list) {
        data = list;
    }

    @Override
    public Hodler onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Hodler(LayoutInflater.from(parent.getContext()).inflate(R.layout.lay_more_data, parent, false));
    }

    @Override
    public void onBindViewHolder(Hodler holder, int position) {
        holder.tv.setText(data.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Hodler extends RecyclerView.ViewHolder {

        private TextView tv;

        public Hodler(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.lay_tv);
        }
    }
}
