package com.org.appfragme.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.org.appfragme.R;
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
    private Context context;

    private ActionBarHelper() {}
    private ActionBarHelper(Context context, CommonTitleBar titleBar, ActionBar actionBar) {
        this.context = context;
        this.actionBar = actionBar;
        this.titleBar = titleBar;
    }

    /**
     * 初始化
     * @return
     */
    public static ActionBarHelper getInstance() {
        if (instance == null) {
            synchronized (ActionBarHelper.class) {
                if (instance == null) {
                    instance = new ActionBarHelper();
                }
            }
        }
        return instance;
    }

    /**
     * 获取标题辅助类
     * @param context
     * @param titleBar
     * @param actionBar
     * @return
     */
    public static ActionBarHelper getInstance(Context context, CommonTitleBar titleBar, ActionBar actionBar) {
        if (instance == null) {
            synchronized (ActionBarHelper.class) {
                if (instance == null) {
                    instance = new ActionBarHelper(context, titleBar, actionBar);
                }
            }
        }
        return instance;
    }

    /**
     *
     * @return
     */
    public boolean clearHelper() {
        instance = null;
        return true;
    }

    /**
     * 初始化TitleBar
     *
     * @return
     */
    public ActionBarHelper builder() {
        XXXLog.e("Helper   走了吗 ？  " + JSON.toJSONString(actionBar));
        if (actionBar != null && titleBar != null) {
            if (!actionBar.isShowTitleBar()) {
                titleBar.setVisibility(View.GONE);
            } else {
                XXXLog.v("  ---------------------  " + actionBar.getCenterText());
                titleBar.setVisibility(View.VISIBLE);
                titleBar.setLeftType(actionBar.getLeftType())
                        .setLeftText(actionBar.getLeftText())
                        .setLeftTextColor(actionBar.getLeftTextColor())
                        .setLeftTextSize(actionBar.getLeftTextSize())
                        .setLeftImageResource(actionBar.getLeftImageResource())
                        .setLeftDrawable(actionBar.getLeftDrawable())
                        .setLeftDrawablePadding(actionBar.getLeftDrawablePadding())
                        .setLeftCustomViewRes(actionBar.getLeftCustomViewRes())
                        .setRightType(actionBar.getRightType())
                        .setRightText(actionBar.getRightText())
                        .setRightTextColor(actionBar.getRightTextColor())
                        .setRightCustomViewRes(actionBar.getRightCustomViewRes())
                        .setCenterType(actionBar.getCenterType())
                        .setCenterText(actionBar.getCenterText())
                        .setCenterTextColor(actionBar.getCenterTextColor())
                        .setCenterTextSize(actionBar.getCenterTextSize())
                        .setCenterSubText(actionBar.getCenterSubText())
                        .setCenterSubTextColor(actionBar.getCenterSubTextColor())
                        .setCenterSubTextSize(actionBar.getCenterSubTextSize())
                        .setCenterSearchBgResource(actionBar.getCenterSearchBgResource())
                        .setCenterSearchEdiable(actionBar.isCenterSearchEdiable())
                        .setCenterSearchRightType(actionBar.getCenterSearchRightType())
                        .setCenterCustomViewRes(actionBar.getCenterCustomViewRes())
                        .setFillStatusBar(actionBar.isFillStatusBar())
                        .setTitleBarColor(actionBar.getTitleBarColor())
                        .setTitleBarHeight(actionBar.getTitleBarHeight())
                        .setStatusBarColor(actionBar.getStatusBarColor())
                        .setShowBottomLine(actionBar.isShowBottomLine())
                        .setBottomElevation(actionBar.getBottomElevation())
                        .builder();
            }
        }
        return this;
    }

    /**
     * 初始化action bar
     *
     * @return
     */
    public ActionBarHelper builderActionBar() {
        actionBar.setShowTitleBar(true)
                .setFillStatusBar(true)
                .setTitleBarColor(Color.parseColor("#ffffff"))
                .setTitleBarHeight(DensityUtils.dp2PxInt(context, 44))
                .setStatusBarColor(Color.parseColor("#ffffff"))
                .setShowBottomLine(true)
                .setBottomLineColor(Color.parseColor("#dddddd"))
                .setBottomElevation(DensityUtils.dp2PxInt(context, 5))
                .setLeftType(CommonTitleBar.TYPE_LEFT_NONE)
                .setLeftText("")
                .setLeftTextColor(context.getResources().getColor(R.color.comm_titlebar_text_selector))
                .setLeftTextSize(DensityUtils.dp2PxInt(context, 16))
                .setLeftDrawable(0)
                .setLeftDrawablePadding(5)
                .setLeftImageResource(R.drawable.comm_titlebar_reback_selector)
                .setLeftCustomViewRes(0)
                .setRightType(CommonTitleBar.TYPE_RIGHT_NONE)
                .setRightText("")
                .setRightTextColor(CommonTitleBar.TYPE_RIGHT_NONE)
                .setRightTextColor(context.getResources().getColor(R.color.comm_titlebar_text_selector))
                .setRightTextSize(DensityUtils.dp2PxInt(context, 16))
                .setRightImageResource(0)
                .setRightCustomViewRes(0)
                .setCenterType(CommonTitleBar.TYPE_CENTER_NONE)
                .setCenterText("")
                .setCenterTextColor(Color.parseColor("#333333"))
                .setCenterTextSize(DensityUtils.dp2PxInt(context, 18))
                .setCenterSubText("")
                .setCenterSubTextColor(Color.parseColor("#666666"))
                .setCenterSearchEdiable(true)
                .setCenterSearchBgResource(R.drawable.comm_titlebar_search_gray_shape)
                .setCenterSearchRightType(CommonTitleBar.TYPE_CENTER_SEARCH_RIGHT_VOICE)
                .setCenterCustomViewRes(0);
        return this;
    }

}
