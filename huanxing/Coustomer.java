package com.itheima.huanxing;

public class Coustomer implements Runnable{
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.class) {
                if(Desk.flag==true){
                    System.out.println("开始吃包子");
                    Desk.flag=false;
                    Desk.class.notifyAll();
                }else {
                    System.out.println("消费者抢到，没包子");
                    try {
                        Desk.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
