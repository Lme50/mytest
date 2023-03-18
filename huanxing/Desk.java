package com.itheima.huanxing;

public class Desk {

    public  static  boolean flag=false;
    public static void main(String[] args) {
        Thread t1=new Thread(new Coustomer());
        Thread t2=new Thread(new Product());
        t1.start();
        t2.start();

    }
}
