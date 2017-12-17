package com.xiaoyu.longlegged.delegate;

import android.support.annotation.NonNull;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.org.appfragme.utils.XXXLog;
import com.org.appfragme.view.ActivityDelegate;
import com.org.appfragme.view.FragmentDelegate;
import com.org.appfragme.widget.ActionBar;
import com.xiaoyu.longlegged.R;
import com.xiaoyu.longlegged.base.FragmentPage;
import com.xiaoyu.longlegged.common.AppMethod;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Created: xiaoyu  on 2017.12.04 17:11.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.04 17:11.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class WelcomeDelegate extends FragmentDelegate {

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_welcome;
    }

    @Override
    public void initWidget(View contentView) {
        super.initWidget(contentView);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                AppMethod.postShowWith(getActivity(), FragmentPage.Main);
            }
        };
        timer.schedule(timerTask, 2000);
    }

    @Override
    public void setTitleBar(@NonNull ActionBar titleBar) throws NullPointerException {
        super.setTitleBar(titleBar);
        titleBar.setShowTitleBar(false);
    }
}
