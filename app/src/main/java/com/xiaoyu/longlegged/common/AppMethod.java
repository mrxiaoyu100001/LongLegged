package com.xiaoyu.longlegged.common;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.org.appfragme.databind.CallBack;
import com.org.appfragme.databind.DataBindFragment;
import com.org.appfragme.presenter.FragmentPresenter;
import com.org.appfragme.presenter.FragmentStack;
import com.org.appfragme.utils.ALiBaBa;
import com.org.appfragme.utils.ActionBarHelper;
import com.org.appfragme.utils.ViewInject;
import com.org.appfragme.utils.XXXLog;
import com.org.appfragme.widget.ActionBar;
import com.xiaoyu.longlegged.MainActivity;
import com.xiaoyu.longlegged.MyApplication;
import com.xiaoyu.longlegged.base.FragmentPage;
import com.xiaoyu.longlegged.delegate.MainDelegate;

import static android.content.Context.ACTIVITY_SERVICE;

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

    private static boolean isExist;

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
        mainDelegate.changePage(page, resultCode, MyApplication.fragmentStack.getBackStackTop());
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
        mainDelegate.changePage(page, bundle, resultCode, MyApplication.fragmentStack.getBackStackTop());
    }

    /**
     * 退出app
     * @param activity
     * @throws Exception
     */
    public static void AppOver(Activity activity) throws Exception {
        if (!isExist) {
            ViewInject.longToast("再按一次退出");
            isExist = true;
            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isExist = false;
                }
            }, 3000);
        } else {
            clearApp();
            if (Integer.parseInt(android.os.Build.VERSION.SDK) >= android.os.Build.VERSION_CODES.ECLAIR_MR1) {
                Intent mainActivity = new Intent(Intent.ACTION_MAIN);
                mainActivity.addCategory(Intent.CATEGORY_HOME);
                mainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                activity.startActivity(mainActivity);
                System.exit(0);//退出程序
            } else {
                ActivityManager activityMgr = (ActivityManager) activity.getSystemService(ACTIVITY_SERVICE);
                activityMgr.restartPackage(activity.getPackageName());
            }
        }
    }

    /*清除缓存数据*/
    private static void clearApp() {
        MyApplication.fragmentStack.removeAllFragment();
        ActionBarHelper.getInstance().clearHelper();
        ActionBar.getInstance().clearActionBar();
    }
}
