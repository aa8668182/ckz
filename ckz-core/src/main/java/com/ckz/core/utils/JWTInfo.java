package com.ckz.core.utils;

import java.io.Serializable;


public class JWTInfo implements Serializable,IJWTInfo {
    private String loginAccount;
    private String userId;
    private String loginName;
    private String appId;

    public JWTInfo(String loginAccount, String userId, String loginName,String appId) {
        this.loginAccount = loginAccount;
        this.userId = userId;
        this.loginName = loginName;
        this.appId = appId;
    }

    @Override
    public String getUniqueName() {
        return loginAccount;
    }

    public void setUsername(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    @Override
    public String getId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getName() {
        return loginName;
    }

    @Override
    public String getAppId() {
        return appId;
    }

    public void setName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JWTInfo jwtInfo = (JWTInfo) o;

        if (loginAccount != null ? !loginAccount.equals(jwtInfo.loginAccount) : jwtInfo.loginAccount != null) {
            return false;
        }
        return userId != null ? userId.equals(jwtInfo.userId) : jwtInfo.userId == null;

    }

    @Override
    public int hashCode() {
        int result = loginAccount != null ? loginAccount.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
