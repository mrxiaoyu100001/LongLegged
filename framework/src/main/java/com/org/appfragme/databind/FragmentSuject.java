package com.org.appfragme.databind;

import android.os.Bundle;

import com.org.appfragme.utils.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created: xiaoyu  on 2017.12.12 16:23.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.12 16:23.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class FragmentSuject implements Subject {

    private static FragmentSuject instance;
    private List<Observer> observers;

    private FragmentSuject() {
        observers = new ArrayList<>(Constant.stackNum);
    }

    public static FragmentSuject getInstance() {
        if (instance == null) {
            synchronized (FragmentSuject.class) {
                if (instance == null) {
                    instance = new FragmentSuject();
                }
            }
        }
        return instance;
    }

    @Override
    public Subject addObserver(Observer observer) {
        if (observers != null && !observers.contains(observer)) {
            observers.add(observer);
        }
        return this;
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers != null && observer != null) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyChange() {
        notify(null, null);
    }

    @Override
    public void notifyChange(Object data) {
        notify(data, null);
    }

    @Override
    public void notifyChage(Object data, Bundle bundle) {
        notify(data, bundle);
    }

    private void notify(Object object, Bundle bundle) {
        if (observers != null) {
            for (Observer observer : observers) {
                if (bundle == null) {
                    if (object == null) {
                        observer.updatePage();
                    } else {
                        observer.updatePage(object);
                    }
                } else {
                    observer.updatePage((Class<?>) object, bundle);
                }
            }
        }
    }
}
