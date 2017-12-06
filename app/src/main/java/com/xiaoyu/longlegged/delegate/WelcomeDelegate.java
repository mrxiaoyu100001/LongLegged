package com.xiaoyu.longlegged.delegate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.org.appfragme.view.AppDelegate;
import com.org.appfragme.view.IDelegate;
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

public class WelcomeDelegate extends AppDelegate {

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
}
