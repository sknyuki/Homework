package com.example.demo.utility;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test extends Thread{

    private static int test;
    private static Lock lock;

    public Test (){
        Test.test = 0;
        lock = new ReentrantLock();
    }

    public static int getTestNum (){

        int tmp;

       // lock.lock();
        tmp = Test.test;
       // lock.unlock();

        return tmp;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (;;) {
            try {
                lock.lock();

                Test.test += 1;

            } catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            Thread.sleep(3000);
        }
    }
}
