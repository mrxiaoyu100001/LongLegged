package com.xiaoyu.longlegged.modle;

import com.org.appfragme.model.IModel;

import java.util.List;

/**
 * @Created: xiaoyu  on 2017.12.07 21:09.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.07 21:09.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class MoreDataList implements IModel {

    private List<MoreData> data;

    public List<MoreData> getData() {
        return data;
    }

    public void setData(List<MoreData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MoreDataList{" +
                "data=" + data +
                '}';
    }
}
