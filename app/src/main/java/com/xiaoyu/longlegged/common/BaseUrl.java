package com.xiaoyu.longlegged.common;

import com.fdlm.util.DESUtil;

/**
 * @Created: xiaoyu  on 2017.12.19 17:01.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.19 17:01.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class BaseUrl {

    public static DESUtil desutil = new DESUtil("540OVX3d6fHGP8c5e312024be9dfg6s2");
    private static final String BaseUrl = "longleg/v1/service/";
    public static final String Login = "user/login";
    public static final String MainUrl = BaseUrl + "pub/home";
    public static final String TestUrl = "user/postAuthor";
}
