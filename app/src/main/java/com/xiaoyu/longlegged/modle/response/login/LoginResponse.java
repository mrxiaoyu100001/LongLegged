package com.xiaoyu.longlegged.modle.response.login;

/**
 *  登录返回值
 * @author zm
 */
public class LoginResponse {

    private LoginBean data;

    public LoginBean getData() {
        return data;
    }

    public void setData(LoginBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "data=" + data +
                '}';
    }
}
