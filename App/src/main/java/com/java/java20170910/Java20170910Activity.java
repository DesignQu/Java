package com.java.java20170910;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.java.java20170910.code.code1.SendFactory;
import com.java.java20170910.code.code1.Sender;
import com.java.java20170910.code.code2.Singleton;
import com.java.java20170910.code.code3.MyBuilder;
import com.java.java20170910.code.code4.Prototype;
import com.java.java20170910.code.code5.AdapterTest;
import com.java.java20170910.code.code5.Targetable;
import com.java.java20170910.code.code6.SourceSub1;
import com.java.java20170910.code.code6.SourceSub2;
import com.java.java20170910.code.code6.Sourceable;

import java.io.IOException;

/**
 * https://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html
 * <p>
 * Java设计模式的分类
 * 三大类
 * 创建型模式，共五种：工厂模式、抽象工厂模式、单例模式、建造者模式、原型模式。
 * 结构型模式，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。
 * 行为型模式，共十一种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。
 * 还有两类：并发型模式和线程池模式
 * <p>
 * 设计模式的六大原则
 * 1、开闭原则（Open Close Principle）
 * 开闭原则就是说对扩展开放，对修改关闭。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。所以一句话概括就是：为了使程序的扩展性好，易于维护和升级。想要达到这样的效果，我们需要使用接口和抽象类，后面的具体设计中我们会提到这点。
 * 2、里氏代换原则（Liskov Substitution Principle）
 * 里氏代换原则(Liskov Substitution Principle LSP)面向对象设计的基本原则之一。 里氏代换原则中说，任何基类可以出现的地方，子类一定可以出现。 LSP是继承复用的基石，只有当衍生类可以替换掉基类，软件单位的功能不受到影响时，基类才能真正被复用，而衍生类也能够在基类的基础上增加新的行为。里氏代换原则是对“开-闭”原则的补充。实现“开-闭”原则的关键步骤就是抽象化。而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实现抽象化的具体步骤的规范。—— From Baidu 百科
 * 3、依赖倒转原则（Dependence Inversion Principle）
 * 这个是开闭原则的基础，具体内容：真对接口编程，依赖于抽象而不依赖于具体。
 * 4、接口隔离原则（Interface Segregation Principle）
 * 这个原则的意思是：使用多个隔离的接口，比使用单个接口要好。还是一个降低类之间的耦合度的意思，从这儿我们看出，其实设计模式就是一个软件的设计思想，从大型软件架构出发，为了升级和维护方便。所以上文中多次出现：降低依赖，降低耦合。
 * 5、迪米特法则（最少知道原则）（Demeter Principle）
 * 为什么叫最少知道原则，就是说：一个实体应当尽量少的与其他实体之间发生相互作用，使得系统功能模块相对独立。
 * 6、合成复用原则（Composite Reuse Principle）
 * 原则是尽量使用合成/聚合的方式，而不是使用继承。
 */
public class Java20170910Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 创建型模式
        Log.e("---", "工厂模式--------------------------------------------------------------------------------------------------");
        code1();

        Log.e("---", "单例模式--------------------------------------------------------------------------------------------------");
        code2();

        Log.e("---", "建造者模式--------------------------------------------------------------------------------------------------");
        code3();

        Log.e("---", "原型模式--------------------------------------------------------------------------------------------------");
        code4();

        // 结构型模式
        Log.e("---", "适配器模式--------------------------------------------------------------------------------------------------");
        code5();

        Log.e("---", "接口的适配器模式--------------------------------------------------------------------------------------------------");
        code6();

        Log.e("---", "--------------------------------------------------------------------------------------------------");
        code7();
    }

    /**
     * 模式
     */
    private void code7() {

    }

    /**
     * 接口的适配器模式
     * 有时我们写的一个接口中有多个抽象方法，当我们写该接口的实现类时，必须实现该接口的所有方法，这明显有时比较浪费，
     * 因为并不是所有的方法都是我们需要的，有时只需要某一些，此处为了解决这个问题，我们引入了接口的适配器模式，借助于一个抽象类，
     * 该抽象类实现了该接口，实现了所有的方法，而我们不和原始的接口打交道，只和该抽象类取得联系，所以我们写一个类，继承该抽象类，
     * 重写我们需要的方法就行。
     */
    private void code6() {
        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();

        source1.method1();
        source1.method2();
        source2.method1();
        source2.method2();
    }

    /**
     * 适配器模式
     * 有一个Source类，拥有一个方法，待适配，目标接口时Targetable，通过Adapter类，将Source的功能扩展到Targetable里
     * 输出：
     * this is original method!
     * this is the targetable method!
     * 这样Targetable接口的实现类就具有了Source类的功能。
     */
    private void code5() {
        Targetable target = new AdapterTest();
        target.method1();
        target.method2();
    }

    /**
     * 原型模式虽然是创建型的模式，但是与工程模式没有关系，从名字即可看出，该模式的思想就是将一个对象作为原型，
     * 对其进行复制、克隆，产生一个和原对象类似的新对象。在Java中，复制对象是通过clone()实现的
     */
    private void code4() {
        Prototype prototype = new Prototype();
        try {
            Prototype prototype1 = (Prototype) prototype.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        try {
            Prototype prototype2 = (Prototype) prototype.deepClone();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 建造者模式
     */
    private void code3() {
        MyBuilder.builder().a(123).b("fdfsdf").build();
    }

    /**
     * 单例模式
     */
    private void code2() {
        Log.e("code2", Singleton.getSingletonA() + "");
        Log.e("code2", Singleton.getSingletonA() + "");
//        Singleton.getSingleton();
    }

    /**
     * 总结工厂模式
     * <p>
     * 凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。
     * 在以上的三种模式中
     * 第一种如果传入的字符串有误，不能正确创建对象，
     * 第三种相对于第二种，不需要实例化工厂类，
     * 所以，大多数情况下，我们会选用第三种——静态工厂方法模式。
     */
    private void code1() {
        Log.e("---", "工厂模式--------------------------------------------------------------------------------------");
        SendFactory sendFactory = new SendFactory();
        Sender sender0 = sendFactory.produce(0);
        sender0.send();
        Sender sender1 = sendFactory.produce(1);
        sender1.send();
        Log.e("---", "多个工厂模式--------------------------------------------------------------------------------------------------");
        Sender sender2 = sendFactory.produceSms();
        sender2.send();
        Sender sender3 = sendFactory.produceMail();
        sender3.send();
        Log.e("---", "静态工厂模式--------------------------------------------------------------------------------------------------");
        Sender sender4 = SendFactory.produceStaticMail();
        sender4.send();
    }
}
