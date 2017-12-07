package com.xiaoyu.longlegged.delegate;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.org.appfragme.view.AppDelegate;
import com.xiaoyu.longlegged.R;
import com.xiaoyu.longlegged.adapter.MoreDataAdapter;
import com.xiaoyu.longlegged.modle.MoreDataList;

/**
 * @Created: xiaoyu  on 2017.12.07 20:56.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.07 20:56.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class MoreDataDelegate extends AppDelegate {

    private RecyclerView rv_content;
    private TextView tv_content;
    private MoreDataAdapter adapter;

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_more_data;
    }

    @Override
    public void initWidget(View contentView) {
        super.initWidget(contentView);
        rv_content = bindView(R.id.frag_rl_content);
        tv_content = bindView(R.id.frag_tv_content);
        adapter = new MoreDataAdapter();
    }

    /**
     *
     * @param data
     */
    public void setData(MoreDataList data) {

    }
}
