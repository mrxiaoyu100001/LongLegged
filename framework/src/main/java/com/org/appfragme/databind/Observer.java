package com.org.appfragme.databind;

import android.os.Bundle;

/**
 * @Created: xiaoyu  on 2017.12.12 16:17.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.12 16:17.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public interface Observer<D> {
    public void updatePage();
    public void updatePage(D data);
    public void updatePage(Class<?> cla, Bundle bundle);
    public void updateTitle();
    public void updateTitle(D data);
}
