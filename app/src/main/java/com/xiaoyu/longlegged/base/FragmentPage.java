package com.xiaoyu.longlegged.base;

import com.xiaoyu.longlegged.fragment.MainFragment;

/**
 * @Created by xiaoyu on 2017/1/6.
 * @Describe：跳转Fragment的枚举类
 * @Review by：
 * @Modify by：
 * @Version : $ v_1.0 on 2017/1/6.
 * @Remark:
 */
public enum FragmentPage {

    /*每个人的key 按自己的顺序排列 以下只是一个简单的例子，请各位做相应的替换*/
    /*@author: xiaoyu    1 - 100      */
    Main(1, MainFragment.class);
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
