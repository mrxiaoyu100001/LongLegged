package com.xiaoyu.longlegged.delegate;

import android.support.annotation.NonNull;
import android.view.View;

import com.org.appfragme.utils.ViewInject;
import com.org.appfragme.view.FragmentDelegate;
import com.org.appfragme.widget.ActionBar;
import com.org.appfragme.widget.CommonTitleBar;
import com.xiaoyu.longlegged.R;

/**
 * @Created: xiaoyu  on 2017.12.07 10:12.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.07 10:12.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class DetailDelegate extends FragmentDelegate {

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_detail;
    }

    @Override
    public void setTitleBar(@NonNull ActionBar titleBar) throws NullPointerException {
        super.setTitleBar(titleBar);
        titleBar.setLeftType(CommonTitleBar.TYPE_LEFT_TEXTVIEW)
                .setLeftDrawable(R.drawable.comm_titlebar_reback_selector)
                .setLeftText(R.string.detail_back)
                .setLeftTextColor(R.color.color_ffffff)
                .setCenterType(CommonTitleBar.TYPE_CENTER_TEXTVIEW)
                .setCenterText(R.string.frag_detail)
                .setCenterTextColor(R.color.color_ffffff)
                .setRightType(CommonTitleBar.TYPE_RIGHT_TEXTVIEW)
                .setRightText(R.string.detail_sub)
                .setRightTextColor(R.color.color_ffffff);
    }

    @Override
    public void onBarClicked(View v, int action, String extra) {
        super.onBarClicked(v, action, extra);
        if (action == CommonTitleBar.ACTION_RIGHT_TEXT) {
            ViewInject.showCenterToast(this.getActivity(), "提交了");
        }
    }
}
