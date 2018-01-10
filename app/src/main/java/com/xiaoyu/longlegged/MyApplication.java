package com.xiaoyu.longlegged;

import android.support.multidex.MultiDexApplication;

import com.org.appfragme.presenter.AppBuilder;
import com.org.appfragme.presenter.FragmentStack;
import com.org.appfragme.utils.Constant;
import com.org.utillib.utils.HttpManager;

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

    public static FragmentStack fragmentStack;

    @Override
    public void onCreate() {
        super.onCreate();
        fragmentStack = AppBuilder.init(Constant.stackNum);
        HttpManager.builder(this, "http://192.168.62.138:8080/web-ssm/");
//        HttpManager.builder(this, "http://192.168.62.138:8080/interface_supplier/");
    }

}
