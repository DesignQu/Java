package com.java.java20170910.code.code8;

import android.util.Log;

/**
 * Created by SZLD-PC-249 on 2018/3/9.
 */

public class Proxy8 implements Sourceable8 {

    private Source8 source;

    public Proxy8() {
        super();
        this.source = new Source8();
    }

    @Override
    public void method() {
        before();
        source.method();
        atfer();
    }

    private void atfer() {
        Log.e("Proxy8", "after proxy!");
    }

    private void before() {
        Log.e("Proxy8", "before proxy!");
    }
}
