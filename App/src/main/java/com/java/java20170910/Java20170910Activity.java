package com.java.java20170910;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.java.java20170910.code.code1.SendFactory;
import com.java.java20170910.code.code1.Sender;
import com.java.java20170910.code.code10.Bridge;
import com.java.java20170910.code.code10.MyBridge;
import com.java.java20170910.code.code10.SourceSub101;
import com.java.java20170910.code.code10.SourceSub102;
import com.java.java20170910.code.code10.Sourceable10;
import com.java.java20170910.code.code2.Singleton;
import com.java.java20170910.code.code3.MyBuilder;
import com.java.java20170910.code.code4.Prototype;
import com.java.java20170910.code.code5.AdapterTest;
import com.java.java20170910.code.code5.Targetable;
import com.java.java20170910.code.code6.SourceSub1;
import com.java.java20170910.code.code6.SourceSub2;
import com.java.java20170910.code.code6.Sourceable;
import com.java.java20170910.code.code7.Decorator;
import com.java.java20170910.code.code7.Source;
import com.java.java20170910.code.code7.Sourceable7;
import com.java.java20170910.code.code8.Proxy8;
import com.java.java20170910.code.code8.Sourceable8;
import com.java.java20170910.code.code9.Computer;

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

        Log.e("---", "装饰模式--------------------------------------------------------------------------------------------------");
        code7();

        Log.e("---", "代理模式--------------------------------------------------------------------------------------------------");
        code8();

        Log.e("---", "外观模式--------------------------------------------------------------------------------------------------");
        code9();

        Log.e("---", "桥接模式--------------------------------------------------------------------------------------------------");
        code10();

        Log.e("---", "--------------------------------------------------------------------------------------------------");
        code11();

        Log.e("---", "--------------------------------------------------------------------------------------------------");
        code12();

        Log.e("---", "--------------------------------------------------------------------------------------------------");
        code13();
    }

    /**
     * 模式
     */
    private void code13() {

    }

    /**
     * 模式
     */
    private void code12() {

    }

    /**
     * 模式
     */
    private void code11() {

    }

    /**
     * 桥接模式
     * <p>
     * 桥接模式就是把事物和其具体实现分开，使他们可以各自独立的变化。桥接的用意是：将抽象化与实现化解耦，使得二者可以独立变化，
     * 像我们常用的JDBC桥DriverManager一样，JDBC进行连接数据库的时候，在各个数据库之间进行切换，基本不需要动太多的代码，甚至丝毫不用动，
     * 原因就是JDBC提供统一接口，每个数据库提供各自的实现，用一个叫做数据库驱动的程序来桥接就行了。
     */
    private void code10() {
        Bridge bridge = new MyBridge();

        /*调用第一个对象*/
        Sourceable10 source1 = new SourceSub101();
        bridge.setSource(source1);
        bridge.method();

        /*调用第二个对象*/
        Sourceable10 source2 = new SourceSub102();
        bridge.setSource(source2);
        bridge.method();
    }

    /**
     * 外观模式
     * <p>
     * 外观模式是为了解决类与类之间的依赖关系的，外观模式就是将他们的关系放在一个Facade类中，降低了类类之间的耦合度
     * <p>
     * 如果我们没有Computer类，那么，CPU、Memory、Disk他们之间将会相互持有实例，产生关系，这样会造成严重的依赖，
     * 修改一个类，可能会带来其他类的修改，这不是我们想要看到的，有了Computer类，他们之间的关系被放在了Computer类里，这样就起到了解耦的作用，这，就是外观模式！
     */
    private void code9() {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }

    /**
     * 代理模式
     * 其实每个模式名称就表明了该模式的作用，代理模式就是多一个代理类出来，替原对象进行一些操作，比如我们在租房子的时候回去找中介，
     * 为什么呢？因为你对该地区房屋的信息掌握的不够全面，希望找一个更熟悉的人去帮你做，此处的代理就是这个意思。再如我们有的时候打官司，
     * 我们需要请律师，因为律师在法律方面有专长，可以替我们进行操作，表达我们的想法。
     * <p>
     * 代理模式的应用场景：
     * 如果已有的方法在使用的时候需要对原有的方法进行改进，此时有两种办法：
     * 1、修改原有的方法来适应。这样违反了“对扩展开放，对修改关闭”的原则。
     * 2、采用一个代理类调用原有的方法，且对产生的结果进行控制。这种方法就是代理模式。
     * 使用代理模式，可以将功能划分的更加清晰，有助于后期维护！
     */
    private void code8() {
        Sourceable8 source = new Proxy8();
        source.method();
    }

    /**
     * 装饰模式
     * 装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例
     * 1、需要扩展一个类的功能。
     * 2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不能动态增删。）
     * 缺点：产生过多相似的对象，不易排错！
     */
    private void code7() {
        Sourceable7 source = new Source();
        Sourceable7 obj = new Decorator(source);
        obj.method();
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
