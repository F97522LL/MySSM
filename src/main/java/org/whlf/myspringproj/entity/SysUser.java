package org.whlf.myspringproj.entity;

public class SysUser extends PageEntity {
    private String id;  //用户ID
    private String userName;     //账号
    private String password;     //密码

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}