package com.org.appfragme.widget;

import android.content.Context;
import android.view.View;

import com.org.appfragme.utils.DensityUtils;

/**
 * @Created: xiaoyu  on 2017.12.13 19:23.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.13 19:23.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class ActionBar {

    private static ActionBar instance;
    private Context context;

    private ActionBar(){}
    private ActionBar(Context context) {
        this.context = context;
    }

    /**
     * 初始化
     * @return
     */
    public static ActionBar getInstance() {
        if (instance == null) {
            synchronized (ActionBar.class) {
                if (instance == null) {
                    instance = new ActionBar();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化标题辅助类
     *
     * @return
     */
    public static ActionBar getInstance(Context context) {
        if (instance == null) {
            synchronized (ActionBar.class) {
                if (instance == null) {
                    instance = new ActionBar(context);
                }
            }
        }
        return instance;
    }

    /**
     * 清除缓存
     * @return
     */
    public boolean clearActionBar() {
        instance = null;
        return true;
    }

    private boolean showTitleBar;                       // 是否显示标题栏
    private View viewStatusBarFill;                     // 状态栏填充视图
    private View viewBottomLine;                        // 分隔线视图
    private boolean fillStatusBar;                      // 是否撑起状态栏, true时,标题栏浸入状态栏
    private boolean isShowStatusBar;                    // 是否填充状态栏
    private int statusBarPic;                           // 状态栏背景图片
    private int titleBarColor;                          // 标题栏背景颜色
    private int titleBarHeight;                         // 标题栏高度
    private int statusBarColor;                         // 状态栏颜色
    private boolean showBottomLine;                     // 是否显示底部分割线
    private int bottomLineColor;                        // 分割线颜色
    private float bottomElevation;                      // elevation效果深度
    private int leftType;                               // 左边视图类型
    private String leftText;                            // 左边TextView文字
    private int leftTextColor;                          // 左边TextView颜色
    private float leftTextSize;                         // 左边TextView文字大小
    private int leftDrawable;                           // 左边TextView drawableLeft资源
    private float leftDrawablePadding;                  // 左边TextView drawablePadding
    private int leftImageResource;                      // 左边图片资源
    private int leftCustomViewRes;                      // 左边自定义视图布局资源
    private int rightType;                               // 右边视图类型
    private String rightText;                           // 右边TextView文字
    private int rightTextColor;                         // 右边TextView颜色
    private float rightTextSize;                        // 右边TextView文字大小
    private int rightImageResource;                     // 右边图片资源
    private int rightCustomViewRes;                     // 右边自定义视图布局资源
    private int centerType;                             // 中间视图类型
    private String centerText;                          // 中间TextView文字
    private int centerTextColor;                        // 中间TextView字体颜色
    private float centerTextSize;                       // 中间TextView字体大小
    private String centerSubText;                       // 中间subTextView文字
    private int centerSubTextColor;                     // 中间subTextView字体颜色
    private float centerSubTextSize;                    // 中间subTextView字体大小
    private boolean centerSearchEdiable;                // 搜索框是否可输入
    private int centerSearchBgResource;                 // 搜索框背景图片
    private int centerSearchRightType;                  // 搜索框右边按钮类型  0: voice 1: delete
    private int centerCustomViewRes;                    // 中间自定义布局资源

    public boolean isShowTitleBar() {
        return showTitleBar;
    }

    public int getCenterCustomViewRes() {
        return centerCustomViewRes;
    }

    public int getCenterSearchRightType() {
        return centerSearchRightType;
    }

    public int getCenterSearchBgResource() {
        return centerSearchBgResource;
    }

    public boolean isCenterSearchEdiable() {
        return centerSearchEdiable;
    }

    public float getCenterSubTextSize() {
        return centerSubTextSize;
    }

    public int getCenterSubTextColor() {
        return centerSubTextColor;
    }

    public String getCenterSubText() {
        return centerSubText;
    }

    public float getCenterTextSize() {
        return centerTextSize;
    }

    public int getCenterTextColor() {
        return centerTextColor;
    }

    public String getCenterText() {
        return centerText;
    }

    public int getCenterType() {
        return centerType;
    }

    public int getRightCustomViewRes() {
        return rightCustomViewRes;
    }

    public int getRightImageResource() {
        return rightImageResource;
    }

    public float getRightTextSize() {
        return rightTextSize;
    }

    public int getRightTextColor() {
        return rightTextColor;
    }

    public String getRightText() {
        return rightText;
    }

    public int getLeftCustomViewRes() {
        return leftCustomViewRes;
    }

    public int getLeftImageResource() {
        return leftImageResource;
    }

    public float getLeftDrawablePadding() {
        return leftDrawablePadding;
    }

    public int getLeftDrawable() {
        return leftDrawable;
    }

    public float getLeftTextSize() {
        return leftTextSize;
    }

    public int getLeftTextColor() {
        return leftTextColor;
    }

    public String getLeftText() {
        return leftText;
    }

    public int getLeftType() {
        return leftType;
    }

    public float getBottomElevation() {
        return bottomElevation;
    }

    public int getBottomLineColor() {
        return bottomLineColor;
    }

    public boolean isShowBottomLine() {
        return showBottomLine;
    }

    public int getStatusBarColor() {
        return statusBarColor;
    }

    public int getTitleBarHeight() {
        return titleBarHeight;
    }

    public int getTitleBarColor() {
        return titleBarColor;
    }

    public boolean isFillStatusBar() {
        return fillStatusBar;
    }

    public View getViewBottomLine() {
        return viewBottomLine;
    }

    public View getViewStatusBarFill() {
        return viewStatusBarFill;
    }

    public int getRightType() {
        return rightType;
    }

    public int getStatusBarPic() {
        return statusBarPic;
    }

    public ActionBar setStatusBarPic(int statusBarPic) {
        this.statusBarPic = statusBarPic;
        return this;
    }

    public boolean isShowStatusBar() {
        return isShowStatusBar;
    }

    public ActionBar setShowStatusBar(boolean showStatusBar) {
        isShowStatusBar = showStatusBar;
        return this;
    }

    public ActionBar setRightType(int rightType) {
        this.rightType = rightType;
        return this;
    }

    public ActionBar setShowTitleBar(boolean showTitleBar) {
        this.showTitleBar = showTitleBar;
        return this;
    }

    public ActionBar setViewStatusBarFill(View viewStatusBarFill) {
        this.viewStatusBarFill = viewStatusBarFill;
        return this;
    }

    public ActionBar setViewBottomLine(View viewBottomLine) {
        this.viewBottomLine = viewBottomLine;
        return this;
    }

    public ActionBar setFillStatusBar(boolean fillStatusBar) {
        this.fillStatusBar = fillStatusBar;
        return this;
    }

    public ActionBar setTitleBarColor(int titleBarColor) {
        this.titleBarColor = context.getResources().getColor(titleBarColor);
        return this;
    }

    public ActionBar setTitleBarHeight(int titleBarHeight) {
        this.titleBarHeight = DensityUtils.dp2PxInt(context, titleBarHeight);
        return this;
    }

    public ActionBar setStatusBarColor(int statusBarColor) {
        this.statusBarColor = context.getResources().getColor(statusBarColor);
        return this;
    }

    public ActionBar setShowBottomLine(boolean showBottomLine) {
        this.showBottomLine = showBottomLine;
        return this;
    }

    public ActionBar setBottomLineColor(int bottomLineColor) {
        this.bottomLineColor = context.getResources().getColor(bottomLineColor);
        return this;
    }

    public ActionBar setBottomElevation(float bottomElevation) {
        this.bottomElevation = DensityUtils.dp2PxInt(context, bottomElevation);
        return this;
    }

    public ActionBar setLeftType(int leftType) {
        this.leftType = leftType;
        return this;
    }

    public ActionBar setLeftText(String leftText) {
        this.leftText = leftText;
        return this;
    }
    public ActionBar setLeftText(int leftText) {
        this.leftText = context.getResources().getString(leftText);
        return this;
    }

    public ActionBar setLeftTextColor(int leftTextColor) {
        this.leftTextColor = context.getResources().getColor(leftTextColor);
        return this;
    }

    public ActionBar setLeftTextSize(float leftTextSize) {
        this.leftTextSize = DensityUtils.dp2PxInt(context, leftTextSize);
        return this;
    }

    public ActionBar setLeftDrawable(int leftDrawable) {
        this.leftDrawable = leftDrawable;
        return this;
    }

    public ActionBar setLeftDrawablePadding(float leftDrawablePadding) {
        this.leftDrawablePadding = leftDrawablePadding;
        return this;
    }

    public ActionBar setLeftImageResource(int leftImageResource) {
        this.leftImageResource = leftImageResource;
        return this;
    }

    public ActionBar setLeftCustomViewRes(int leftCustomViewRes) {
        this.leftCustomViewRes = leftCustomViewRes;
        return this;
    }

    public ActionBar setRightText(String rightText) {
        this.rightText = rightText;
        return this;
    }
    public ActionBar setRightText(int rightText) {
        this.rightText = context.getString(rightText);
        return this;
    }

    public ActionBar setRightTextColor(int rightTextColor) {
        this.rightTextColor = context.getResources().getColor(rightTextColor);
        return this;
    }

    public ActionBar setRightTextSize(float rightTextSize) {
        this.rightTextSize = DensityUtils.dp2PxInt(context, rightTextSize);
        return this;
    }

    public ActionBar setRightImageResource(int rightImageResource) {
        this.rightImageResource = rightImageResource;
        return this;
    }

    public ActionBar setRightCustomViewRes(int rightCustomViewRes) {
        this.rightCustomViewRes = rightCustomViewRes;
        return this;
    }

    public ActionBar setCenterType(int centerType) {
        this.centerType = centerType;
        return this;
    }

    public ActionBar setCenterText(String centerText) {
        this.centerText = centerText;
        return this;
    }

    public ActionBar setCenterText(int centerText) {
        this.centerText = context.getResources().getString(centerText);
        return this;
    }

    public ActionBar setCenterTextColor(int centerTextColor) {
        this.centerTextColor = context.getResources().getColor(centerTextColor);
        return this;
    }

    public ActionBar setCenterTextSize(float centerTextSize) {
        this.centerTextSize = DensityUtils.dp2PxInt(context, centerTextSize);
        return this;
    }

    public ActionBar setCenterSubText(String centerSubText) {
        this.centerSubText = centerSubText;
        return this;
    }

    public ActionBar setCenterSubTextColor(int centerSubTextColor) {
        this.centerSubTextColor = context.getResources().getColor(centerSubTextColor);
        return this;
    }

    public ActionBar setCenterSubTextSize(float centerSubTextSize) {
        this.centerSubTextSize = centerSubTextSize;
        return this;
    }

    public ActionBar setCenterSearchEdiable(boolean centerSearchEdiable) {
        this.centerSearchEdiable = centerSearchEdiable;
        return this;
    }

    public ActionBar setCenterSearchBgResource(int centerSearchBgResource) {
        this.centerSearchBgResource = centerSearchBgResource;
        return this;
    }

    public ActionBar setCenterSearchRightType(int centerSearchRightType) {
        this.centerSearchRightType = centerSearchRightType;
        return this;
    }

    public ActionBar setCenterCustomViewRes(int centerCustomViewRes) {
        this.centerCustomViewRes = centerCustomViewRes;
        return this;
    }

    @Override
    public String toString() {
        return "ActionBar{" +
                "showTitleBar=" + showTitleBar +
                ", viewStatusBarFill=" + viewStatusBarFill +
                ", viewBottomLine=" + viewBottomLine +
                ", fillStatusBar=" + fillStatusBar +
                ", titleBarColor=" + titleBarColor +
                ", titleBarHeight=" + titleBarHeight +
                ", statusBarColor=" + statusBarColor +
                ", showBottomLine=" + showBottomLine +
                ", bottomLineColor=" + bottomLineColor +
                ", bottomElevation=" + bottomElevation +
                ", leftType=" + leftType +
                ", leftText='" + leftText + '\'' +
                ", leftTextColor=" + leftTextColor +
                ", leftTextSize=" + leftTextSize +
                ", leftDrawable=" + leftDrawable +
                ", leftDrawablePadding=" + leftDrawablePadding +
                ", leftImageResource=" + leftImageResource +
                ", leftCustomViewRes=" + leftCustomViewRes +
                ", rightType=" + rightType +
                ", rightText='" + rightText + '\'' +
                ", rightTextColor=" + rightTextColor +
                ", rightTextSize=" + rightTextSize +
                ", rightImageResource=" + rightImageResource +
                ", rightCustomViewRes=" + rightCustomViewRes +
                ", centerType=" + centerType +
                ", centerText='" + centerText + '\'' +
                ", centerTextColor=" + centerTextColor +
                ", centerTextSize=" + centerTextSize +
                ", centerSubText='" + centerSubText + '\'' +
                ", centerSubTextColor=" + centerSubTextColor +
                ", centerSubTextSize=" + centerSubTextSize +
                ", centerSearchEdiable=" + centerSearchEdiable +
                ", centerSearchBgResource=" + centerSearchBgResource +
                ", centerSearchRightType=" + centerSearchRightType +
                ", centerCustomViewRes=" + centerCustomViewRes +
                '}';
    }
}
