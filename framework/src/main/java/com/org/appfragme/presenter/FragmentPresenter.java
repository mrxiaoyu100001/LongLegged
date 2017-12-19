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
package com.org.appfragme.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.org.appfragme.databind.CallBack;
import com.org.appfragme.databind.Subject;
import com.org.appfragme.utils.XXXLog;
import com.org.appfragme.view.FragmentDelegate;


/**
 * @param <T> View delegate class type
 * @author kymjs (http://www.kymjs.com/) on 10/23/15.
 */

/**
 * @Created: xiaoyu  on 2017.12.06 17:34.
 * @Describe：Presenter base class for Fragment Presenter层的实现基类
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.06 17:34.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */
public abstract class FragmentPresenter<T extends FragmentDelegate> extends Fragment implements CallBack {
    public T viewDelegate;
    private CallBack callBack;
    private Subject suject;

    public FragmentPresenter() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            viewDelegate = getDelegateClass().newInstance();
            viewDelegate.setCallBack(suject, callBack);
            if (viewDelegate == null) XXXLog.e(" viewDelegate  " + viewDelegate);
            ((ActivityPresenter) getActivity()).getTitleBar().setListener(viewDelegate);
            ((ActivityPresenter) getActivity()).getTitleBar().setDoubleClickListener(viewDelegate);
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        viewDelegate.create(inflater, container, savedInstanceState);
        return viewDelegate.getRootView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDelegate.initWidget(viewDelegate.getRootView());
        bindEvenListener();
    }

    protected void initData(Bundle bundle) {
    }

    protected void bindEvenListener() {
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if (viewDelegate.getOptionsMenuId() != 0) {
            inflater.inflate(viewDelegate.getOptionsMenuId(), menu);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (viewDelegate == null) {
            try {
                viewDelegate = getDelegateClass().newInstance();
                viewDelegate.setCallBack(suject, callBack);
                if (viewDelegate == null) XXXLog.e(" viewDelegate  " + viewDelegate);
                ((ActivityPresenter) getActivity()).getTitleBar().setListener(viewDelegate);
                ((ActivityPresenter) getActivity()).getTitleBar().setDoubleClickListener(viewDelegate);
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewDelegate = null;
        callBack = null;
        suject = null;
    }

    protected abstract Class<T> getDelegateClass();

    public abstract boolean onBackEvent();

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public void setCallBack(Subject suject, CallBack callBack) {
        this.suject = suject;
        this.callBack = callBack;
    }
}
