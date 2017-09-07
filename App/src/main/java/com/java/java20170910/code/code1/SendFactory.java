package com.java.java20170910.code.code1;

/**
 * 工厂类
 */
public class SendFactory {

    // 工厂方法模式
    public Sender produce(int type) {
        if (type == 0) {
            return new SmsSender();
        } else if (type == 1) {
            return new MailSender();
        } else {
            return null;
        }
    }

    // 多个工厂方法模式
    public Sender produceSms() {
        return new SmsSender();
    }

    public Sender produceMail() {
        return new MailSender();
    }

    // 静态工厂方法模式
    public static Sender produceStaticMail() {
        return new MailSender();
    }
}