package com.xiaoyu.longlegged.base;

import android.os.Bundle;

import com.org.appfragme.databind.CallBack;

/**
 * @Created: xiaoyu  on 2017.12.04 18:14.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.04 18:14.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public interface Mediator{
    public void changePage(FragmentPage page);
    public void changePage(FragmentPage page, Bundle bundle);
    public void changePage(FragmentPage page, int requestCode);
    public void changePage(FragmentPage page, Bundle bundle, int requestCode);
    public void backChange();
    public void backChange(FragmentPage page);
}
