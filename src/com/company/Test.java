package com.company;

import java.sql.SQLOutput;

public class Test extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Java!!");
    }
}
