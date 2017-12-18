package com.xiaoyu.longlegged.delegate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.org.appfragme.utils.Constant;
import com.org.appfragme.utils.DensityUtils;
import com.org.appfragme.utils.RecyclerViewItemDecoration;
import com.org.appfragme.view.base.FragmentDelegate;
import com.org.appfragme.widget.ActionBar;
import com.org.appfragme.widget.CommonTitleBar;
import com.xiaoyu.longlegged.R;
import com.xiaoyu.longlegged.adapter.MoreDataAdapter;
import com.xiaoyu.longlegged.base.FragmentPage;
import com.xiaoyu.longlegged.common.AppMethod;
import com.xiaoyu.longlegged.modle.MoreData;
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

public class MoreDataDelegate extends FragmentDelegate {

    private RecyclerView rv_content;
    private TextView tv_content;
    private MoreDataAdapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_more_data;
    }

    @Override
    public void setTitleBar(@NonNull ActionBar titleBar) throws NullPointerException {
        super.setTitleBar(titleBar);
        titleBar.setLeftType(CommonTitleBar.TYPE_LEFT_TEXTVIEW)
                .setLeftDrawable(R.drawable.comm_titlebar_reback_selector)
                .setLeftText(R.string.detail_back)
                .setLeftTextColor(R.color.color_ffffff)
                .setCenterType(CommonTitleBar.TYPE_CENTER_TEXTVIEW)
                .setCenterText(R.string.frag_more)
                .setCenterTextColor(R.color.color_ffffff)
                .setRightType(CommonTitleBar.TYPE_RIGHT_CUSTOM_VIEW)
                .setRightCustomViewRes(R.layout.layout_custom);
    }

    @Override
    public void onDoubleClicked(View v) {
        super.onDoubleClicked(v);
        manager.scrollToPosition(0);
    }

    @Override
    public void initWidget(View contentView) {
        super.initWidget(contentView);
        rv_content = bindView(R.id.frag_rl_content);
        tv_content = bindView(R.id.frag_tv_content);
        rv_content.setHasFixedSize(true);
        manager = new LinearLayoutManager(this.getActivity());
        rv_content.setLayoutManager(manager);
        rv_content.addItemDecoration(new RecyclerViewItemDecoration(RecyclerViewItemDecoration.MODE_HORIZONTAL,
                getActivity().getResources().getColor(R.color.color_eeeeee), DensityUtils.dip2dp(this.getActivity(), 1), 0, 0));
        adapter = new MoreDataAdapter();
        rv_content.setAdapter(adapter);
        adapter.setOnItemClick(new MoreDataAdapter.onItemClick() {
            @Override
            public void onItemClick(MoreData itemData) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.Constant_key, itemData);
                setResult(Constant.Constant_one, bundle);
                finish();
            }
        });
        setOnClickListener(this, R.id.frag_tv_content);
    }

    @Override
    public void widgetClick(View view) {
        super.widgetClick(view);
        Bundle bundle = new Bundle();
        bundle.putString(Constant.Constant_key, getActivity().getString(R.string.app_content));
        AppMethod.postShowWith(this.getActivity(), FragmentPage.Othor, bundle);
    }

    /**
     * @param data
     */
    public void setData(MoreDataList data) {
        adapter.refresh(data.getData());
    }
}
