package com.xiaoyu.longlegged.fragment;

import android.os.Bundle;

import com.org.appfragme.databind.DataBindFragment;
import com.org.appfragme.databind.DataBinder;
import com.org.appfragme.utils.Constant;
import com.org.appfragme.utils.XXXLog;
import com.xiaoyu.longlegged.dataBinder.SearchDateBinder;
import com.xiaoyu.longlegged.delegate.SearchDelegate;
import com.xiaoyu.longlegged.modle.MoreData;

/**
 * @Created: xiaoyu  on 2017.12.05 15:18.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.05 15:18.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class SearchFragment extends DataBindFragment<SearchDelegate> {

    @Override
    public DataBinder getDataBinder() {
        return new SearchDateBinder();
    }

    @Override
    protected Class<SearchDelegate> getDelegateClass() {
        return SearchDelegate.class;
    }

    @Override
    protected void initData(Bundle bundle) {
        super.initData(bundle);
    }

    @Override
    public boolean onBackEvent() {
        return false;
    }

    @Override
    public void onActivityResult(int resultCode, Bundle data) {
        super.onActivityResult(resultCode, data);
        viewDelegate.setText((MoreData) data.get(Constant.Constant_key));
    }
}
