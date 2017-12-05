package com.xiaoyu.longlegged;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.org.appfragme.presenter.AppBuilder;
import com.org.appfragme.presenter.FragmentStack;

/**
 * @Created: xiaoyu  on 2017.12.01 16:46.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.01 16:46.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class MyApplication extends MultiDexApplication {

    //应用最大界面数
    private static final int stackNum = 300;
    public static FragmentStack fragmentStack;

    @Override
    public void onCreate() {
        super.onCreate();
        fragmentStack = AppBuilder.init(stackNum);
    }
}
