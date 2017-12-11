package com.xiaoyu.longlegged.fragment;

import com.org.appfragme.databind.DataBindFragment;
import com.org.appfragme.databind.DataBinder;
import com.org.appfragme.presenter.FragmentPresenter;
import com.xiaoyu.longlegged.delegate.WelcomeDelegate;

/**
 * @Created: xiaoyu  on 2017.12.04 17:10.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.04 17:10.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class WelcomeFrament extends DataBindFragment<WelcomeDelegate> {
    @Override
    public DataBinder getDataBinder() {
        return null;
    }

    @Override
    protected Class<WelcomeDelegate> getDelegateClass() {
        return WelcomeDelegate.class;
    }

    @Override
    public boolean onBackEvent() {
        return false;
    }
}
