package com.xiaoyu.longlegged.fragment;

import android.os.Bundle;

import com.org.appfragme.databind.DataBindFragment;
import com.org.appfragme.databind.DataBinder;
import com.org.appfragme.utils.Constant;
import com.xiaoyu.longlegged.delegate.OthorDelegate;

/**
 * @Created: xiaoyu  on 2017.12.12 18:53.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.12 18:53.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class OthorFragment extends DataBindFragment<OthorDelegate> {

    @Override
    public DataBinder getDataBinder() {
        return null;
    }

    @Override
    protected Class<OthorDelegate> getDelegateClass() {
        return OthorDelegate.class;
    }

    @Override
    protected void initData(Bundle bundle) {
        super.initData(bundle);
        viewDelegate.refreshTitle(bundle.getString(Constant.Constant_key));
    }
}
