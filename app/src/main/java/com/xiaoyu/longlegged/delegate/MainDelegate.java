package com.xiaoyu.longlegged.delegate;

import com.org.appfragme.view.AppDelegate;
import com.xiaoyu.longlegged.MyApplication;
import com.xiaoyu.longlegged.R;
import com.xiaoyu.longlegged.base.FragmentPage;
import com.xiaoyu.longlegged.base.Mediator;

/**
 * @Created: xiaoyu  on 2017.12.01 16:57.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.01 16:57.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class MainDelegate extends AppDelegate implements Mediator {

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget() {
        super.initWidget();
       changePage(FragmentPage.Wellcome);
    }

    @Override
    public void changePage(FragmentPage page) {
        Class cla = FragmentPage.getPageByValue(page.getValue());
        changeFragment(R.id.act_fl_content,  MyApplication.fragmentStack.addFragment(cla));
    }
}
