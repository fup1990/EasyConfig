package com.gome.fup.easyconfig.common;

/**
 * Created by fupeng-ds on 2017/8/16.
 */
public class HttpResponse {

    private int status;

    private Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
