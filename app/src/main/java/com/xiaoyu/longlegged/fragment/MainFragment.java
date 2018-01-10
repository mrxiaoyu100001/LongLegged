package com.xiaoyu.longlegged.fragment;

import android.os.Bundle;

import com.alibaba.fastjson.JSON;
import com.org.appfragme.databind.DataBindFragment;
import com.org.appfragme.databind.DataBinder;
import com.org.appfragme.utils.XXXLog;
import com.org.utillib.utils.AesUtil;
import com.vise.log.ViseLog;
import com.vise.netexpand.mode.ApiResult;
import com.vise.netexpand.request.ApiPostRequest;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;
import com.xiaoyu.longlegged.common.BaseUrl;
import com.xiaoyu.longlegged.delegate.MainFragDelegate;
import com.xiaoyu.longlegged.modle.request.LoginRequest;
import com.xiaoyu.longlegged.modle.response.login.LoginResponse;

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

    @Override
    protected void initData(Bundle bundle) {
        super.initData(bundle);
        XXXLog.e(" ----------------------------   initdata()   ");
    }
}
