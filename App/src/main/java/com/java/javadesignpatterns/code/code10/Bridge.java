package com.java.javadesignpatterns.code.code10;

/**
 * Created by SZLD-PC-249 on 2018/3/9.
 */

public abstract class Bridge {

    private Sourceable10 source;

    public void method(){
        source.method();
    }

    public Sourceable10 getSource() {
        return source;
    }

    public void setSource(Sourceable10 source) {
        this.source = source;
    }
}
