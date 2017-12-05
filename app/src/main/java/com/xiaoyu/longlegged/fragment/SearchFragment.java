package com.xiaoyu.longlegged.fragment;

import com.org.appfragme.databind.DataBindFragment;
import com.org.appfragme.databind.DataBinder;
import com.xiaoyu.longlegged.delegate.SearchDelegate;

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
        return null;
    }

    @Override
    protected Class<SearchDelegate> getDelegateClass() {
        return SearchDelegate.class;
    }
}
