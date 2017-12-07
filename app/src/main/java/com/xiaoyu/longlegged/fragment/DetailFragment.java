package com.xiaoyu.longlegged.fragment;

import com.org.appfragme.databind.DataBindFragment;
import com.org.appfragme.databind.DataBinder;
import com.xiaoyu.longlegged.delegate.DetailDelegate;

/**
 * @Created: xiaoyu  on 2017.12.07 10:12.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.07 10:12.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class DetailFragment extends DataBindFragment<DetailDelegate> {

    @Override
    public DataBinder getDataBinder() {
        return null;
    }

    @Override
    protected Class<DetailDelegate> getDelegateClass() {
        return DetailDelegate.class;
    }

    @Override
    public boolean onBackEvent() {
        return false;
    }
}
