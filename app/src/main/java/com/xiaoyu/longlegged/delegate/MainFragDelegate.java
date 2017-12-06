package com.xiaoyu.longlegged.delegate;

import android.os.Bundle;
import android.view.View;

import com.org.appfragme.utils.Constant;
import com.org.appfragme.utils.XXXLog;
import com.org.appfragme.view.AppDelegate;
import com.org.appfragme.widget.CommonTitleBar;
import com.xiaoyu.longlegged.R;
import com.xiaoyu.longlegged.base.FragmentPage;
import com.xiaoyu.longlegged.common.AppMethod;

/**
 * @Created: xiaoyu  on 2017.12.04 17:13.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.04 17:13.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class MainFragDelegate extends AppDelegate implements CommonTitleBar.OnTitleBarListener{

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initWidget(View contentView) {
        super.initWidget(contentView);
        CommonTitleBar titleBar = bindView(R.id.frag_ct_title);
        titleBar.setListener(this);
    }

    @Override
    public void onClicked(View v, int action, String extra) {
        if (action == CommonTitleBar.ACTION_RIGHT_BUTTON){
            Bundle bundle = new Bundle();
            bundle.putString(Constant.Constant_key, getActivity().getString(R.string.app_content));
            AppMethod.postShowWith(this.getActivity(), FragmentPage.Search, bundle);
        }else if (action == CommonTitleBar.ACTION_LEFT_BUTTON){
//            AppMethod.postShowWith(this.getActivity(), FragmentPage.Search, Constant.Constant_one);
        }
    }
}
