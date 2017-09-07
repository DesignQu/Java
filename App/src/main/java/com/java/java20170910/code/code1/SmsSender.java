package com.java.java20170910.code.code1;

import android.util.Log;

/**
 *
 */
public class SmsSender implements Sender {

    @Override
    public void send() {
        Log.e("send", "send SmsSender");
    }
}