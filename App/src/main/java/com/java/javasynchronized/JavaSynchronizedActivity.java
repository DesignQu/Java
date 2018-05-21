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
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();

        // 把上面代码改成下面这样的
        // 发现thread3和thread4同时在执行。这是因为synchronized只锁定对象，每个对象只有一个锁（lock）与之相关联
        // 这时会有两把锁分别锁定syncThread1对象和syncThread2对象，而这两把锁是互不干扰的，不形成互斥，所以两个线程可以同时执行。
        SyncThread syncThread1 = new SyncThread();
        SyncThread syncThread2 = new SyncThread();
        Thread thread3 = new Thread(syncThread1, "SyncThread1");
        Thread thread4 = new Thread(syncThread2, "SyncThread2");
        thread3.start();
        thread4.start();
    }

    // 修饰代码块
    class SyncThread implements Runnable {
        private int count;

        public SyncThread() {
            count = 0;
        }

        public void run() {
            synchronized (this) {// 可以去掉此行代码，查看不同的结果
                for (int i = 0; i < 5; i++) {
                    try {
                        Logg.e(Thread.currentThread().getName() + ":" + (count++));
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
