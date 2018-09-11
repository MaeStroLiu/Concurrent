package com.jjst;

public class HttpRequstUtil {


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new ThreadTest();
            thread.start();
        }
    }
}
