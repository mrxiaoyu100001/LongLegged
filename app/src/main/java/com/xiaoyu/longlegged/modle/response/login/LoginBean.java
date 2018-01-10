package com.xiaoyu.longlegged.modle.response.login;

/**
 * Created by meicai on 17/4/13.
 */

public class LoginBean {

    private String userId;//用户Id
    private String accountId;//账户id
    private String userName;//用户名称
    private String imgPath;//头像
    private String cellphone;//电话号码
    private String orgId; //组织Id
    private String status; //用户状态
    private String shopsCode; //商铺code
    private String shopsName; //商铺名称
    private String accountShopsId; //商铺名称

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShopsCode() {
        return shopsCode;
    }

    public void setShopsCode(String shopsCode) {
        this.shopsCode = shopsCode;
    }

    public String getShopsName() {
        return shopsName;
    }

    public void setShopsName(String shopsName) {
        this.shopsName = shopsName;
    }

    public String getAccountShopsId() {
        return accountShopsId;
    }

    public void setAccountShopsId(String accountShopsId) {
        this.accountShopsId = accountShopsId;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "userId='" + userId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", userName='" + userName + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", orgId='" + orgId + '\'' +
                ", status='" + status + '\'' +
                ", shopsCode='" + shopsCode + '\'' +
                ", shopsName='" + shopsName + '\'' +
                ", accountShopsId='" + accountShopsId + '\'' +
                '}';
    }
}
