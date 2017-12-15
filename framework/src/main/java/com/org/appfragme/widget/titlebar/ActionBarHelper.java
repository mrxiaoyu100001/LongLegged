package com.org.appfragme.utils;

import com.org.appfragme.widget.ActionBar;
import com.org.appfragme.widget.CommonTitleBar;

/**
 * @Created: xiaoyu  on 2017.12.15 11:11.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.15 11:11.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class ActionBarHelper {

    private ActionBar actionBar;
    private CommonTitleBar titleBar;
    private static ActionBarHelper instance;

    private ActionBarHelper(CommonTitleBar titleBar, ActionBar actionBar) {
        this.actionBar = actionBar;
        this.titleBar = titleBar;
    }

    public static ActionBarHelper getInstance(CommonTitleBar titleBar, ActionBar actionBar) {
        if (instance == null) {
            synchronized (ActionBarHelper.class) {
                if (instance == null) {
                    instance = new ActionBarHelper(titleBar, actionBar);
                }
            }
        }
        return instance;
    }

    public void builder() {

    }

}
