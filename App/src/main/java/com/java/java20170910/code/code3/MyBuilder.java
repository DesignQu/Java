package com.java.java20170910.code.code3;

/**
 * 建造者模式
 */
public class MyBuilder {

    private int a;
    private String b;

    public MyBuilder(Builder builder){
        this. a =  builder.a;
        this. b =  builder.b;
    }

    public static Builder builder(){
        return new Builder();
    }

    public  static class Builder{

         private int a;
         private String b;

         public Builder a(int a){
             this. a =  a;
             return this;
         }

         public Builder b(String b){
             this. b =  b;
             return this;
         }

         public MyBuilder build(){
             return new MyBuilder(this);
         }
    }
}
