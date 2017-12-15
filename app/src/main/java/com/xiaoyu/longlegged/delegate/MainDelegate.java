package com.xiaoyu.longlegged.delegate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.org.appfragme.databind.CallBack;
import com.org.appfragme.databind.FragmentSuject;
import com.org.appfragme.databind.Observer;
import com.org.appfragme.presenter.FragmentPresenter;
import com.org.appfragme.utils.ActionBarHelper;
import com.org.appfragme.utils.ViewInject;
import com.org.appfragme.utils.XXXLog;
import com.org.appfragme.view.ActivityDelegate;
import com.org.appfragme.view.FragmentDelegate;
import com.org.appfragme.widget.ActionBar;
import com.org.appfragme.widget.CommonTitleBar;
import com.xiaoyu.longlegged.MyApplication;
import com.xiaoyu.longlegged.R;
import com.xiaoyu.longlegged.base.FragmentPage;
import com.xiaoyu.longlegged.base.Mediator;
import com.xiaoyu.longlegged.common.AppMethod;

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

public class MainDelegate extends ActivityDelegate implements Mediator, Observer<FragmentPage> {

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
    public void setTitleBar(@NonNull ActionBar titleBar) throws NullPointerException {
        super.setTitleBar(titleBar);
        ActionBarHelper
                .getInstance(this.getActivity(), (CommonTitleBar) get(R.id.frag_ct_title), titleBar)
                .builderActionBar()
                .builder();
    }

    @Override
    public void changePage(FragmentPage page) {
        Class cla = FragmentPage.getPageByValue(page.getValue());
        FragmentPresenter presenter = MyApplication.fragmentStack.addFragment(cla);
        presenter.setCallBack(FragmentSuject.getInstance().addObserver(this), null);
        enterChangeFragment(R.id.act_fl_content, presenter);
    }

    @Override
    public void changePage(FragmentPage page, Bundle bundle) {
        Class cla = FragmentPage.getPageByValue(page.getValue());
        FragmentPresenter presenter = MyApplication.fragmentStack.addFragment(cla);
        presenter.setCallBack(FragmentSuject.getInstance().addObserver(this), null);
        presenter.setArguments(bundle);
        enterChangeFragment(R.id.act_fl_content, presenter);
    }

    @Override
    public void changePage(FragmentPage page, int requestCode, CallBack callBack) {
        Class cla = FragmentPage.getPageByValue(page.getValue());
        FragmentPresenter presenter = MyApplication.fragmentStack.addFragment(cla);
        presenter.setCallBack(FragmentSuject.getInstance().addObserver(this), callBack);
        enterChangeFragment(R.id.act_fl_content, presenter);
    }

    @Override
    public void changePage(FragmentPage page, Bundle bundle, int requestCode, CallBack callBack) {
        Class cla = FragmentPage.getPageByValue(page.getValue());
        FragmentPresenter presenter = MyApplication.fragmentStack.addFragment(cla);
        presenter.setCallBack(FragmentSuject.getInstance().addObserver(this), callBack);
        presenter.setArguments(bundle);
        enterChangeFragment(R.id.act_fl_content, presenter);
    }

    @Override
    public void backChange() {
        try {
            Class cla = FragmentPage.getPageByValue(FragmentPage.Main.getValue());
            FragmentPresenter currentFragment = MyApplication.fragmentStack.getBackStackTop();
            if (!currentFragment.onBackEvent()) {
                if (MyApplication.fragmentStack.isTopFragment(cla)) {
                    AppMethod.AppOver(this.getActivity());
                } else {
                    backOutPage();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void backOutPage() {
        outChangeFragment(R.id.act_fl_content, MyApplication.fragmentStack.getNextFragment());
        MyApplication.fragmentStack.removeTopStack();
    }

    private void backOutPage(FragmentPage page) {
        Class cla = FragmentPage.getPageByValue(page.getValue());
        FragmentPresenter presenter = MyApplication.fragmentStack.addFragment(cla);
        outChangeFragment(R.id.act_fl_content, presenter);
    }

    private void backOutPage(Class cla, Bundle bundle) {
        FragmentPresenter presenter = MyApplication.fragmentStack.addFragment(cla);
        presenter.setArguments(bundle);
        outChangeFragment(R.id.act_fl_content, presenter);
    }

    @Override
    public void backChange(FragmentPage page) {

    }

    @Override
    public void updatePage() {
        backOutPage();
    }

    @Override
    public void updatePage(FragmentPage data) {
        backOutPage(data);
    }

    @Override
    public void updatePage(Class<?> data, Bundle bundle) {
        backOutPage(data, bundle);
    }
}
