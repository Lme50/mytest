package com.itheima.huanxing;

public class Product implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.class) {
                if(Desk.flag==false){
                    System.out.println("厨师生产了包子");
                    Desk.flag=true;
                    Desk.class.notifyAll();
                }else {
                    System.out.println("厨师抢到了cpu执行权，但是桌上有包子，厨师等待");
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
