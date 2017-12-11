package com.xiaoyu.longlegged.modle;

import java.io.Serializable;

/**
 * @Created: xiaoyu  on 2017.12.07 21:10.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.07 21:10.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class MoreData implements Serializable {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MoreData{" +
                "value='" + value + '\'' +
                '}';
    }
}
