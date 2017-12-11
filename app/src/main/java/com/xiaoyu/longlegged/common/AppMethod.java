package com.xiaoyu.longlegged.common;

import android.app.Activity;
import android.os.Bundle;

import com.org.appfragme.databind.CallBack;
import com.org.appfragme.databind.DataBindFragment;
import com.org.appfragme.presenter.FragmentPresenter;
import com.xiaoyu.longlegged.MainActivity;
import com.xiaoyu.longlegged.MyApplication;
import com.xiaoyu.longlegged.base.FragmentPage;
import com.xiaoyu.longlegged.delegate.MainDelegate;

/**
 * @Created: xiaoyu  on 2017.12.04 16:38.
 * @Describe：公共方法类
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.04 16:38.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class AppMethod {

    private AppMethod() {
        throw new Error("MethodNotInitException");
    }

    /**
     * @param context
     * @param page
     */
    public static void postShowWith(Activity context, FragmentPage page) {
        MainActivity activity = (MainActivity) context;
        MainDelegate mainDelegate = activity.getDelegate();
        mainDelegate.changePage(page);
    }

    /**
     * @param context
     * @param page
     * @param bundle
     */
    public static void postShowWith(Activity context, FragmentPage page,
                                    Bundle bundle) {
        MainActivity activity = (MainActivity) context;
        MainDelegate mainDelegate = activity.getDelegate();
        mainDelegate.changePage(page, bundle);
    }

    /**
     * 本来觉得用观察者模式去封装，怕别人看不懂，所以不用了直接就用界面来回的切换
     * 数据来回的传递吧，简单直接粗暴。
     * @param context
     * @param page
     * @param resultCode
     */
    public static void postShowWith(Activity context, FragmentPage page,
                                    int resultCode) {
        MainActivity activity = (MainActivity) context;
        MainDelegate mainDelegate = activity.getDelegate();
        FragmentPresenter presenter = MyApplication.fragmentStack.getNextFragment();
        mainDelegate.setCallBack(presenter);
        mainDelegate.changePage(page, resultCode);
    }

    /**
     * @param context
     * @param page
     * @param bundle
     * @param resultCode
     */
    public static void postShowWith(Activity context, FragmentPage page,
                                    Bundle bundle, int resultCode) {
        MainActivity activity = (MainActivity) context;
        MainDelegate mainDelegate = activity.getDelegate();
        FragmentPresenter presenter = MyApplication.fragmentStack.getNextFragment();
        mainDelegate.setCallBack(presenter);
        mainDelegate.changePage(page, bundle, resultCode);
    }

}
