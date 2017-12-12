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
public abstract class AppDelegate implements IDelegate, View.OnClickListener {
    protected final SparseArray<View> mViews = new SparseArray<View>();
    protected View rootView;
    /*当前fragment*/
    private FragmentPresenter currentFragment;
    private CallBack callBack;
    private Subject subject;

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

    public Toolbar getToolbar() {
        return null;
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
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

    public void toast(CharSequence msg) {
        Toast.makeText(rootView.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public <T extends Activity> T getActivity() {
        return (T) rootView.getContext();
    }

    public DataBindFragment getFragment() {
        return (DataBindFragment) currentFragment;
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

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public void setCallBack(Subject context, CallBack callBack) {
        this.callBack = callBack;
        this.subject = context;
    }

    public void setResult(int resultCode, Bundle bundle) {
        if (callBack != null) {
            callBack.onActivityResult(resultCode, bundle);
        }
    }

    public void finish() {
        getActivity().finish();
    }

    public void finishResult() {
        if (subject != null) {
            subject.notifyChange();
        }
    }

    /**
     * 这两个方法冗余了，但是先留着吧，后期再去做维护。
     * @param cla
     */
    public void finishResult(Class<?> cla) {
        if (subject != null) {
            subject.notifyChange(cla);
        }
    }

    public void finishResult(Class<?> cla, Bundle bundle) {
        if (subject != null) {
            subject.notifyChage(cla, bundle);
        }
    }
}
