package com.company;

public class Main {

    /**
     * Driver code to illustrate my program.
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        traffic t = new traffic();
        light s = new light(t);
        t.attach(s);
        t.setFlag(false);
        t.setFlag(true);
        //s.loop();
    }
}
