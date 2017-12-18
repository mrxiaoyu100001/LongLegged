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
package com.org.appfragme.view.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.org.appfragme.widget.ActionBar;

/**
 *
 * @author kymjs (http://www.kymjs.com/) on 10/23/15.
 */
/**
 * @Created: xiaoyu  on 2017.12.06 17:34.
 * @Describe：View delegate base class 视图层代理的接口协议
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.06 17:34.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */
public interface IDelegate {
    void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    int getOptionsMenuId();

    View getRootView();

    void setTitleBar(@NonNull ActionBar titleBar) throws NullPointerException;

    void initWidget(View contentView);

    void widgetClick(View view);

}
