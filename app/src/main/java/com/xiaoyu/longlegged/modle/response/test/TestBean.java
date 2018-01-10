package com.xiaoyu.longlegged.modle.response.test;

/**
 * @Created: xiaoyu  on 2017.12.28 14:53.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.28 14:53.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class TestBean {
    private String code;
    private String data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "code='" + code + '\'' +
                ", data='" + data + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
