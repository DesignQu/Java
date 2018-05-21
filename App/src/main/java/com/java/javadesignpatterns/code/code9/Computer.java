package com.java.javadesignpatterns.code.code9;

import android.util.Log;

/**
 * Created by SZLD-PC-249 on 2018/3/9.
 */

public class Computer {

    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer(){
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void startup(){
        Log.e("Computer", "start the computer!");
        cpu.startup();
        memory.startup();
        disk.startup();
        Log.e("Computer", "start computer finished!");
    }

    public void shutdown(){
        Log.e("Computer", "begin to close the computer!");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        Log.e("Computer", "computer closed!");
    }
}
