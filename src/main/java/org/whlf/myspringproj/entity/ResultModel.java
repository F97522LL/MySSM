package org.whlf.myspringproj.entity;

import java.util.HashMap;
import java.util.Map;

public class ResultModel {
    // 需要显示的信息
    private String message;
    //      返回状态 0>状态正常  <=0说明失败
    private int status;

    //用来保存数据
    private Map<String, Object> data = new HashMap<String, Object>();

    public ResultModel() {
    }

    public ResultModel(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public ResultModel(String message, int status, Map<String, Object> data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

}
