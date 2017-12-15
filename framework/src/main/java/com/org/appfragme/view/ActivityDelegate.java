/*
 * Copyright (c) 2015, 张涛.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.org.appfragme.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import com.org.appfragme.R;
import com.org.appfragme.databind.CallBack;
import com.org.appfragme.databind.DataBindFragment;
import com.org.appfragme.databind.Subject;
import com.org.appfragme.presenter.ActivityPresenter;
import com.org.appfragme.presenter.FragmentPresenter;
import com.org.appfragme.widget.ActionBar;
import com.org.appfragme.widget.CommonTitleBar;


/**
 * @author kymjs (http://www.kymjs.com/) on 10/23/15.
 */

/**
 * @Created: xiaoyu  on 2017.12.06 17:34.
 * @Describe：View delegate base class 视图层代理的基类
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.06 17:34.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */
public abstract class ActivityDelegate implements IDelegate, View.OnClickListener {
    protected final SparseArray<View> mViews = new SparseArray<View>();
    protected View rootView;
    /*当前fragment*/
    private FragmentPresenter currentFragment;

    public abstract int getRootLayoutId();

    @Override
    public void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int rootLayoutId = getRootLayoutId();
        rootView = inflater.inflate(rootLayoutId, container, false);
    }

    @Override
    public int getOptionsMenuId() {
        return 0;
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }

    @Override
    public void setTitleBar(@NonNull ActionBar titleBar) throws NullPointerException {

    }

    @Override
    public void initWidget(View contentView) {

    }

    @Override
    public void widgetClick(View view) {

    }

    @Override
    public void onClick(View view) {
        widgetClick(view);
    }

    public <T extends View> T bindView(int id) {
        T view = (T) mViews.get(id);
        if (view == null) {
            view = (T) rootView.findViewById(id);
            mViews.put(id, view);
        }
        return view;
    }

    public <T extends View> T get(int id) {
        return (T) bindView(id);
    }

    public void setOnClickListener(View.OnClickListener listener, int... ids) {
        if (ids == null) {
            return;
        }
        for (int id : ids) {
            get(id).setOnClickListener(listener);
        }
    }

    public <T extends Activity> T getActivity() {
        return (T) rootView.getContext();
    }

    /**
     * 界面跳转
     *
     * @param resView
     * @param mFragment
     */
    public void enterChangeFragment(int resView, FragmentPresenter mFragment) {
        if (mFragment == null && mFragment.equals(currentFragment)) {
            return;
        }
        FragmentTransaction transaction = ((ActivityPresenter) getActivity()).getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_right_out);
        if (!mFragment.isAdded()) {
            transaction.add(resView, mFragment, mFragment.getClass()
                    .getName());
            /*添加回退栈*/
//            transaction.addToBackStack(mFragment.getClass().getName());
        }
        if (mFragment.isHidden()) {
            transaction.show(mFragment);
        }
        if (currentFragment != null && currentFragment.isVisible()) {
            transaction.hide(currentFragment);
        }
        currentFragment = mFragment;
        transaction.commit();
    }

    /**
     * 界面回退
     *
     * @param resView
     * @param mFragment
     */
    public void outChangeFragment(int resView, FragmentPresenter mFragment) {
        if (mFragment == null && mFragment.equals(currentFragment)) {
            return;
        }
        FragmentTransaction transaction = ((ActivityPresenter) getActivity()).getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out);
        if (!mFragment.isAdded()) {
            transaction.add(resView, mFragment, mFragment.getClass()
                    .getName());
            /*添加回退栈*/
//            transaction.addToBackStack(mFragment.getClass().getName());
        }
        if (mFragment.isHidden()) {
            transaction.show(mFragment);
        }
        if (currentFragment != null && currentFragment.isVisible()) {
            transaction.hide(currentFragment);
        }
        currentFragment = mFragment;
        transaction.commit();
    }

    public void finish() {
        getActivity().finish();
    }

    public ActionBar getActionBar() {
        return ActionBar.getInstance();
    }
}
