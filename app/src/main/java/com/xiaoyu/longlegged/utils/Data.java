package com.xiaoyu.longlegged.utils;

import com.xiaoyu.longlegged.modle.MoreData;
import com.xiaoyu.longlegged.modle.MoreDataList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created: xiaoyu  on 2017.12.07 21:05.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.07 21:05.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class Data {

    private static final int dataNum = 100;
    private static final String data = "成功到底有没有捷径，答案是没有。";

    private Data() {
        throw new AssertionError("No");
    }

    /**
     * 成功的造就了一条姐数据。
     *
     * @return
     */
    public static List<String> getData() {
        List<String> mList = new ArrayList<>(dataNum);
        for (int i = 0; i < dataNum; i++) {
            mList.add(data);
        }
        return mList;
    }

    /**
     * @return
     */
    public static MoreDataList getData1() {
        MoreDataList moreDataList = new MoreDataList();
        List<MoreData> mList = new ArrayList<>(dataNum);
        for (int i = 0; i < dataNum; i++) {
            MoreData moreData = new MoreData();
            moreData.setValue(data);
            mList.add(moreData);
        }
        moreDataList.setData(mList);
        return moreDataList;
    }
}
