package com.kaikele.common;

import java.util.Map;

public class Message {
    private int code;// 200:成功 204:没有内容 500:异常
    private String message;
    private Map data;

    public Message() {

    }

    public Message(int code, String message, Map data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }
}
