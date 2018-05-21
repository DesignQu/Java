package com.java.javadesignpatterns.code.code7;

import android.util.Log;

/**
 * Created by SZLD-PC-249 on 2018/3/7.
 */

public class Decorator implements Sourceable7 {

    private Sourceable7 source;

    public Decorator(Sourceable7 source) {
        super();
        this.source = source;
    }

    @Override
    public void method() {
        Log.e("code7", "before decorator!");
        source.method();
        Log.e("code7", "after decorator!");
    }
}
