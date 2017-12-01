package com.xiaoyu.longlegged;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.org.appfragme.databind.DataBindActivity;
import com.org.appfragme.databind.DataBinder;
import com.xiaoyu.longlegged.dataBinder.MainDateBinder;
import com.xiaoyu.longlegged.delegate.MainDelegate;

public class MainActivity extends DataBindActivity<MainDelegate> {

    @Override
    public DataBinder getDataBinder() {
        return new MainDateBinder();
    }

    @Override
    protected Class<MainDelegate> getDelegateClass() {
        return MainDelegate.class;
    }
}
