package com.xiaoyu.longlegged.delegate;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.org.appfragme.utils.Constant;
import com.org.appfragme.utils.XXXLog;
import com.org.appfragme.view.ActivityDelegate;
import com.org.appfragme.view.FragmentDelegate;
import com.org.appfragme.widget.ActionBar;
import com.xiaoyu.longlegged.R;
import com.xiaoyu.longlegged.base.FragmentPage;
import com.xiaoyu.longlegged.common.AppMethod;

/**
 * @Created: xiaoyu  on 2017.12.04 17:13.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.04 17:13.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class MainFragDelegate extends FragmentDelegate {

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initWidget(View contentView) {
        super.initWidget(contentView);
        setOnClickListener(this, R.id.frag_tv_test);
    }

    @Override
    public void setTitleBar(@NonNull ActionBar titleBar) throws NullPointerException {
        super.setTitleBar(titleBar);
        Resources resources = getActivity().getResources();
        titleBar.setShowTitleBar(true)
                .setLeftDrawable(R.mipmap.main_left)
                .setCenterText(R.string.app_name);
        XXXLog.e("mainfrag  走了吗？  " + titleBar.getCenterText());
        XXXLog.e("mainfrag  走了吗？  " + JSON.toJSONString(titleBar));
    }

    @Override
    public void widgetClick(View view) {
        super.widgetClick(view);
        Bundle bundle = new Bundle();
        bundle.putString(Constant.Constant_key, getActivity().getString(R.string.app_content));
        AppMethod.postShowWith(this.getActivity(), FragmentPage.Search, bundle);
    }
}
