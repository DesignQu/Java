package com.java.java20170910;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.java.java20170910.code.code1.SendFactory;
import com.java.java20170910.code.code1.Sender;

/**
 * Java设计模式的分类
 * 三大类
 * 创建型模式，共五种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。
 * 结构型模式，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。
 * 行为型模式，共十一种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。
 * 还有两类：并发型模式和线程池模式
 */
public class Java20170910Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 工厂方法模式
        code1();

        Log.e("---", "--------------------------------------------------------------------------------------------------");


        Log.e("---", "--------------------------------------------------------------------------------------------------");


        Log.e("---", "--------------------------------------------------------------------------------------------------");


        Log.e("---", "--------------------------------------------------------------------------------------------------");


        Log.e("---", "--------------------------------------------------------------------------------------------------");
    }

    /**
     * 工厂模式适合：
     * 凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。
     * 在以上的三种模式中
     * 第一种如果传入的字符串有误，不能正确创建对象，
     * 第三种相对于第二种，不需要实例化工厂类，
     * 所以，大多数情况下，我们会选用第三种——静态工厂方法模式。
     */
    private void code1() {
        Log.e("---", "工厂方法模式--------------------------------------------------------------------------------------");
        SendFactory sendFactory = new SendFactory();
        Sender sender0 = sendFactory.produce(0);
        sender0.send();
        Sender sender1 = sendFactory.produce(1);
        sender1.send();
        Log.e("---", "多个工厂方法模式--------------------------------------------------------------------------------------------------");
        Sender sender2 = sendFactory.produceSms();
        sender2.send();
        Sender sender3 = sendFactory.produceMail();
        sender3.send();
        Log.e("---", "静态工厂方法模式--------------------------------------------------------------------------------------------------");
        Sender sender4 = SendFactory.produceStaticMail();
        sender4.send();
    }
}
