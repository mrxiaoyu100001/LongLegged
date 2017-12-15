package com.org.appfragme.databind;

import android.os.Bundle;

import java.util.List;

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

public interface Subject<D> {

    Subject addObserver(Observer<D> observer);

    void removeObserver(Observer observer);

    void notifyChange();

    void notifyChange(D data);

    void notifyChage(D data, Bundle bundle);
}
