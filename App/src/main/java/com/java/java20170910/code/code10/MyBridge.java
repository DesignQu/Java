package com.java.java20170910.code.code10;

/**
 * Created by SZLD-PC-249 on 2018/3/9.
 */

public class MyBridge extends Bridge{

    @Override
    public void method() {
        getSource().method();
    }
}
