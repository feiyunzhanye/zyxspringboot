package com.ideal.zyxspringboot.model;

public class ReturnMessage {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;
    private Object data;
    private String filePath;
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ReturnMessage() {}

    public ReturnMessage(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ReturnMessage [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
