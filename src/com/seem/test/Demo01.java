package com.seem.test;

public class Demo01 {

    volatile static boolean flag = true;
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while(true){
                if(flag == !flag){
                    System.out.println(123);
                    break;
                }
                System.out.println(321);
            }
        });

        Thread t2 = new Thread(()->{
            while(true){
                flag = !flag;
                System.out.println("ABC:" + flag);
            }
        });

        t1.start();
        t2.start();
    }
}
