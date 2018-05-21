package com.java.javasynchronized;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.java.javadesignpatterns.code.code1.SendFactory;
import com.java.javadesignpatterns.code.code1.Sender;
import com.java.javadesignpatterns.code.code10.Bridge;
import com.java.javadesignpatterns.code.code10.MyBridge;
import com.java.javadesignpatterns.code.code10.SourceSub101;
import com.java.javadesignpatterns.code.code10.SourceSub102;
import com.java.javadesignpatterns.code.code10.Sourceable10;
import com.java.javadesignpatterns.code.code2.Singleton;
import com.java.javadesignpatterns.code.code3.MyBuilder;
import com.java.javadesignpatterns.code.code4.Prototype;
import com.java.javadesignpatterns.code.code5.AdapterTest;
import com.java.javadesignpatterns.code.code5.Targetable;
import com.java.javadesignpatterns.code.code6.SourceSub1;
import com.java.javadesignpatterns.code.code6.SourceSub2;
import com.java.javadesignpatterns.code.code6.Sourceable;
import com.java.javadesignpatterns.code.code7.Decorator;
import com.java.javadesignpatterns.code.code7.Source;
import com.java.javadesignpatterns.code.code7.Sourceable7;
import com.java.javadesignpatterns.code.code8.Proxy8;
import com.java.javadesignpatterns.code.code8.Sourceable8;
import com.java.javadesignpatterns.code.code9.Computer;

import java.io.IOException;

import me.logg.Logg;

/**
 * Java synchronized 用法小结
 */
public class JavaSynchronizedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 修饰代码块
//        {
//            SyncRunnable runnable = new SyncRunnable();
//            Thread thread1 = new Thread(runnable);
//            Thread thread2 = new Thread(runnable);
//            thread1.start();
//            thread2.start();
//
//            // 把上面代码改成下面这样的
//            // 发现thread3和thread4同时在执行。这是因为synchronized只锁定对象，每个对象只有一个锁（lock）与之相关联
//            // 这时会有两把锁分别锁定syncThread1对象和syncThread2对象，而这两把锁是互不干扰的，不形成互斥，所以两个线程可以同时执行。
//            SyncRunnable runnable1 = new SyncRunnable();
//            SyncRunnable runnable2 = new SyncRunnable();
//            Thread thread3 = new Thread(runnable1);
//            Thread thread4 = new Thread(runnable2);
//            thread3.start();
//            thread4.start();
//
//            Counter account = new Counter("Counter", 1000);
//            CounterOperator counterOperator = new CounterOperator(account);
//            for (int i = 0; i < 5; i++) {
//                Thread thread = new Thread(counterOperator, "Thread" + i);
//                thread.start();
//            }
//        }

        // 修饰静态方法
        {
            SyncStaticRunnable runnable1 = new SyncStaticRunnable();
            SyncStaticRunnable runnable2 = new SyncStaticRunnable();
            Thread thread3 = new Thread(runnable1);
            Thread thread4 = new Thread(runnable2);
            thread3.start();
            thread4.start();
        }

    }

    // 修饰代码块
    class SyncRunnable implements Runnable {

        public void run() {
            synchronized (this) {// 可以去掉此行代码，查看不同的结果
                for (int i = 0; i < 3; i++) {
                    try {
                        Logg.e(i);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Counter {

        String name;
        int count;

        public Counter(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public void add(int count) {
            this.count += count;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void sub(int count) {
            this.count -= count;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public int getCount() {
            return count;
        }
    }

    class CounterOperator implements Runnable {

        private final Counter counter;

        public CounterOperator(Counter counter) {
            this.counter = counter;
        }

        public void run() {
            synchronized (counter) {// 可以去掉此行代码，查看不同的结果
                counter.add(500);
                counter.sub(500);
                Logg.e(Thread.currentThread().getName() + ":" + counter.getCount());
            }
        }
    }

    // 修饰代码块
    static class SyncStaticRunnable implements Runnable {

        public synchronized void run() {
            method();
        }

        public synchronized static void method() {
            for (int i = 0; i < 3; i++) {
                try {
                    Logg.e(i);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}