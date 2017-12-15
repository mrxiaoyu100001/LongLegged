package com.xiaoyu.longlegged.fragment;

import com.org.appfragme.databind.DataBindFragment;
import com.org.appfragme.databind.DataBinder;
import com.org.appfragme.utils.ViewInject;
import com.xiaoyu.longlegged.delegate.MainFragDelegate;

/**
 * @Created: xiaoyu  on 2017.12.04 16:36.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.04 16:36.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class MainFragment extends DataBindFragment<MainFragDelegate> {

    @Override
    public DataBinder getDataBinder() {
        return null;
    }

    @Override
    protected Class<MainFragDelegate> getDelegateClass() {
        return MainFragDelegate.class;
    }

    @Override
    public boolean onBackEvent() {
        return false;
    }
}
