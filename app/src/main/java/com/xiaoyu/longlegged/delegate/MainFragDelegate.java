package com.xiaoyu.longlegged.delegate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.org.appfragme.utils.Constant;
import com.org.appfragme.utils.ViewInject;
import com.org.appfragme.view.FragmentDelegate;
import com.org.appfragme.widget.ActionBar;
import com.org.appfragme.widget.CommonTitleBar;
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
        titleBar.setShowTitleBar(true)
                .setLeftImageResource(R.mipmap.main_left)
                .setCenterType(CommonTitleBar.TYPE_CENTER_TEXTVIEW)
                .setCenterText(R.string.app_name)
                .setCenterTextColor(R.color.color_ffffff)
                .setCenterTextSize(18)
                .setRightType(CommonTitleBar.TYPE_RIGHT_IMAGEBUTTON)
                .setRightImageResource(R.mipmap.main_search);
    }

    @Override
    public void onBarClicked(View v, int action, String extra) {
        super.onBarClicked(v, action, extra);
        switch (action) {
            case CommonTitleBar.ACTION_LEFT_BUTTON:
                ViewInject.showCenterToast(this.getActivity(), "点击了左边");
                break;
            case CommonTitleBar.ACTION_RIGHT_BUTTON:
                ViewInject.showCenterToast(this.getActivity(), "点击了右边");
                break;
        }
    }

    @Override
    public void widgetClick(View view) {
        super.widgetClick(view);
        Bundle bundle = new Bundle();
        bundle.putString(Constant.Constant_key, getActivity().getString(R.string.app_content));
        AppMethod.postShowWith(this.getActivity(), FragmentPage.Search, bundle);
    }
}
