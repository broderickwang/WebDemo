package com.example.webdemo.bean;

public class CoderInfo {

    /**
     * msg : 请求成功
     * code : 000000
     * data : E084A05264702FC3C53FDBE616BD72E2_4123282601_gaoyuan1_null_1532_3&userName=gaoyuan1&realName=%E9%AB%98%E5%8E%9F
     * success : true
     */

    private String msg;
    private String code;
    private String data;
    private boolean success;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "CoderInfo{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data='" + data + '\'' +
                ", success=" + success +
                '}';
    }
}
