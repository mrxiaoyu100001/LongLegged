package com.xiaoyu.longlegged.fragment;

import android.os.Bundle;

import com.org.appfragme.databind.DataBindFragment;
import com.org.appfragme.databind.DataBinder;
import com.org.appfragme.utils.XXXLog;
import com.xiaoyu.longlegged.dataBinder.MoreDataBinder;
import com.xiaoyu.longlegged.delegate.MoreDataDelegate;
import com.xiaoyu.longlegged.utils.Data;

/**
 * @Created: xiaoyu  on 2017.12.07 20:55.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.07 20:55.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class MoreDataFragment extends DataBindFragment<MoreDataDelegate> {

    @Override
    public DataBinder getDataBinder() {
        return new MoreDataBinder();
    }

    @Override
    protected Class<MoreDataDelegate> getDelegateClass() {
        return MoreDataDelegate.class;
    }

    @Override
    protected void initData(Bundle bundle) {
        super.initData(bundle);
        notifyModelChanged(Data.getData1());
    }
}
