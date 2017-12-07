package com.xiaoyu.longlegged.base;

import com.xiaoyu.longlegged.fragment.DetailFragment;
import com.xiaoyu.longlegged.fragment.MainFragment;
import com.xiaoyu.longlegged.fragment.SearchFragment;
import com.xiaoyu.longlegged.fragment.WelcomeFrament;

/**
 * @Created by xiaoyu on 2017/1/6.
 * @Describe：fragment枚举清单列表
 * @Review by：
 * @Modify by：
 * @Version : $ v_1.0 on 2017/1/6.
 * @Remark:
 */
public enum FragmentPage {

    /*每个人的key 按自己的顺序排列 以下只是一个简单的例子，请各位做相应的替换*/
    /*@author: xiaoyu    1 - 100      */
    Wellcome(1, WelcomeFrament.class),
    Main(2, MainFragment.class),
    Search(3, SearchFragment.class),
    Detail(4, DetailFragment.class);
    private Class<?> clazz;
    private int value;

    private FragmentPage(int value, Class<?> cls) {

        this.clazz = cls;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public static Class<?> getPageByValue(int value) {
        for (FragmentPage p : values()) {
            if (p.getValue() == value)
                return p.getClazz();
        }
        return null;
    }
}
