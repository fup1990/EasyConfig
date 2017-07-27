package com.gome.fup.easyconfig;

import com.gome.fup.easyconfig.Util.EasyConfigUtil;

import java.util.Properties;

/**
 * Created by fupeng-ds on 2017/7/27.
 */
public class Test {

    public static void main(String[] args) {
        EasyConfigUtil util = new EasyConfigUtil();
        Properties p = util.getConfig(714l, "test1");
        System.out.println(p);
    }
}
