package com.xiaoyu.longlegged.common;

import android.app.Activity;

import com.xiaoyu.longlegged.MainActivity;
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
     * 界面跳转
     * @param context
     * @param page
     */
    public static void postShowWith(Activity context, FragmentPage page) {
        MainActivity activity = (MainActivity) context;
        MainDelegate mainDelegate = activity.getDelegate();
        mainDelegate.changePage(page);
    }
}
