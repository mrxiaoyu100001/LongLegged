package com.xiaoyu.longlegged.delegate;

import android.os.Bundle;
import android.view.View;

import com.org.appfragme.databind.CallBack;
import com.org.appfragme.presenter.FragmentPresenter;
import com.org.appfragme.utils.ViewInject;
import com.org.appfragme.view.AppDelegate;
import com.xiaoyu.longlegged.MyApplication;
import com.xiaoyu.longlegged.R;
import com.xiaoyu.longlegged.base.FragmentPage;
import com.xiaoyu.longlegged.base.Mediator;

/**
 * @Created: xiaoyu  on 2017.12.01 16:57.
 * @Describe：调停者模式，不知道这样写坑得住压力测试不！！
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
    public void initWidget(View contentView) {
        super.initWidget(contentView);
        changePage(FragmentPage.Wellcome);
    }

    @Override
    public void changePage(FragmentPage page) {
        Class cla = FragmentPage.getPageByValue(page.getValue());
        enterChangeFragment(R.id.act_fl_content, MyApplication.fragmentStack.addFragment(cla));
    }

    @Override
    public void changePage(FragmentPage page, Bundle bundle) {
        Class cla = FragmentPage.getPageByValue(page.getValue());
        FragmentPresenter presenter = MyApplication.fragmentStack.addFragment(cla);
        presenter.setArguments(bundle);
        enterChangeFragment(R.id.act_fl_content, presenter);
    }

    @Override
    public void changePage(FragmentPage page, int requestCode, CallBack callBack) {
        Class cla = FragmentPage.getPageByValue(page.getValue());
        FragmentPresenter presenter = MyApplication.fragmentStack.addFragment(cla);
        enterChangeFragment(R.id.act_fl_content, presenter);
    }

    @Override
    public void changePage(FragmentPage page, Bundle bundle, int requestCode, CallBack callback) {
        Class cla = FragmentPage.getPageByValue(page.getValue());
        enterChangeFragment(R.id.act_fl_content, MyApplication.fragmentStack.addFragment(cla));
    }

    @Override
    public void backChange() {
        Class cla = FragmentPage.getPageByValue(FragmentPage.Main.getValue());
        FragmentPresenter currentFragment = MyApplication.fragmentStack.getBackStackTop();
        if (!currentFragment.onBackEvent()){
            if (MyApplication.fragmentStack.isTopFragment(cla)){
                ViewInject.toast(this.getActivity(), "  直接退出了！！！   ");
                MyApplication.fragmentStack.removeAllFragment();
                getActivity().finish();
            }else {
                outChangeFragment(R.id.act_fl_content, MyApplication.fragmentStack.getNextFragment());
                MyApplication.fragmentStack.removeTopStack();
            }
        }
    }

    @Override
    public void backChange(FragmentPage page) {

    }
}
