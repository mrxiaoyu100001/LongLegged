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
package com.org.appfragme.databind;

import android.os.Bundle;
import android.view.View;

import com.org.appfragme.model.IModel;
import com.org.appfragme.presenter.FragmentPresenter;
import com.org.appfragme.view.IDelegate;

/**
 * @Created: xiaoyu  on 2017.12.06 17:34.
 * @Describe：集成数据-视图绑定的Fragment基类(Presenter层)
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.06 17:34.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */
public abstract class DataBindFragment<T extends IDelegate> extends
        FragmentPresenter<T> {

    protected DataBinder binder;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binder = getDataBinder();
        /*按理说网络家在数据应该有延迟，但是不保证加载数据的时间比初始化时间短。*/
        initData(getArguments());
    }

    public abstract DataBinder getDataBinder();

    public <D extends IModel> void notifyModelChanged(D data) {
        if (binder != null)
            binder.viewBindModel(viewDelegate, data);
    }

    @Override
    public void onActivityResult(int resultCode, Bundle data) {

    }

    @Override
    public boolean onBackEvent() {
        return false;
    }
}
