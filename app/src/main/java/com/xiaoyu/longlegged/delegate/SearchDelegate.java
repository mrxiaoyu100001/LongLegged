package com.xiaoyu.longlegged.delegate;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.org.appfragme.utils.Constant;
import com.org.appfragme.view.base.FragmentDelegate;
import com.org.appfragme.widget.ActionBar;
import com.org.appfragme.widget.CommonTitleBar;
import com.xiaoyu.longlegged.R;
import com.xiaoyu.longlegged.base.FragmentPage;
import com.xiaoyu.longlegged.common.AppMethod;
import com.xiaoyu.longlegged.modle.MoreData;

/**
 * @Created: xiaoyu  on 2017.12.05 15:19.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.05 15:19.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class SearchDelegate extends FragmentDelegate implements View.OnClickListener {

    private TextView tv_sub;

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void initWidget(View contentView) {
        super.initWidget(contentView);
        tv_sub = bindView(R.id.frag_tv_sub3);
        setOnClickListener(this, R.id.frag_tv_sub);
        setOnClickListener(this, R.id.frag_tv_sub2);
    }

    @Override
    public void setTitleBar(@NonNull ActionBar titleBar) throws NullPointerException {
        super.setTitleBar(titleBar);
        titleBar.setCenterText(R.string.main_sub)
                .setTitleBarColor(R.color.color_A973FB)
                .setCenterType(CommonTitleBar.TYPE_CENTER_TEXTVIEW)
                .setCenterTextColor(R.color.color_ffffff);
    }

    @Override
    public void widgetClick(View view) {
        super.widgetClick(view);
        if (view.getId() == R.id.frag_tv_sub) {
            AppMethod.postShowWith(this.getActivity(), FragmentPage.Detail);
        } else if (view.getId() == R.id.frag_tv_sub2) {
            AppMethod.postShowWith(this.getActivity(), FragmentPage.MoreData, Constant.Constant_one);
        }
    }

    public void setText(MoreData data) {
        tv_sub.setText(data.getValue());
    }
}
