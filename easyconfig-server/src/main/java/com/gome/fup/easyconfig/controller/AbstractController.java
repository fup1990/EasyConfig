package com.gome.fup.easyconfig.controller;

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

}
