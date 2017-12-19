package com.xiaoyu.longlegged.delegate;

import android.support.annotation.NonNull;

import com.org.appfragme.view.FragmentDelegate;
import com.org.appfragme.widget.ActionBar;
import com.xiaoyu.longlegged.R;

/**
 * @Created: xiaoyu  on 2017.12.12 18:53.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.12 18:53.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class OthorDelegate extends FragmentDelegate {

    private String title;

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_othor;
    }

    @Override
    public void setTitleBar(@NonNull ActionBar titleBar) throws NullPointerException {
        super.setTitleBar(titleBar);
        titleBar.setCenterText(title);
    }

    public void refreshTitle(String title) {
        this.title = title;
    }
}
