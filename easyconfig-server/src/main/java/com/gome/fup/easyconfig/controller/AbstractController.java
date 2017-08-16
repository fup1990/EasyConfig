package com.gome.fup.easyconfig.controller;

import com.gome.fup.easyconfig.common.HttpResponse;
import com.gome.fup.easyconfig.common.Response;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by fupeng-ds on 2017/8/15.
 */
public class AbstractController {

    protected ObjectMapper mapper = new ObjectMapper();

    protected String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    protected Object success(Object obj) {
        HttpResponse response = new HttpResponse();
        response.setStatus(200);
        response.setData(obj);
        return toJson(response);
    }

    protected Object fail() {
        HttpResponse response = new HttpResponse();
        response.setStatus(400);
        return toJson(response);
    }

}
