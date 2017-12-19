package com.xiaoyu.longlegged.base;

import android.os.Bundle;

import com.org.appfragme.databind.CallBack;
import com.org.appfragme.presenter.FragmentPresenter;
import com.org.appfragme.view.IDelegate;

/**
 * @Created: xiaoyu  on 2017.12.06 15:50.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.06 15:50.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public abstract class BaseFragment<T extends IDelegate> extends FragmentPresenter implements CallBack {

    @Override
    public void onActivityResult( int resultCode, Bundle data) {

    }
}
