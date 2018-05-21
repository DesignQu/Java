package com.java.javadesignpatterns.code.code5;

import android.util.Log;

/**
 * Created by SZLD-PC-249 on 2018/3/7.
 */

public class AdapterTest extends Source implements Targetable {

    @Override
    public void method2() {
        Log.e("code5","this is the targetable method!");
    }
}
