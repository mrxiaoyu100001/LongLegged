package com.xiaoyu.longlegged.dataBinder;

import com.org.appfragme.databind.DataBinder;
import com.org.appfragme.utils.XXXLog;
import com.xiaoyu.longlegged.delegate.MoreDataDelegate;
import com.xiaoyu.longlegged.modle.MoreDataList;

/**
 * @Created: xiaoyu  on 2017.12.07 21:08.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.07 21:08.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class MoreDataBinder implements DataBinder<MoreDataDelegate, MoreDataList> {

    @Override
    public void viewBindModel(MoreDataDelegate viewDelegate, MoreDataList data) {
        viewDelegate.setData(data);
    }
}
