package com.xiaoyu.longlegged;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.org.appfragme.databind.DataBindActivity;
import com.org.appfragme.databind.DataBinder;
import com.org.appfragme.widget.CommonTitleBar;
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

    public MainDelegate getDelegate(){
        return viewDelegate;
    }

    @Override
    public void onBackPressed() {
        viewDelegate.backChange();
    }

    @Override
    protected CommonTitleBar getTitleBar() {
        return viewDelegate.get(R.id.frag_ct_title);
    }
}
