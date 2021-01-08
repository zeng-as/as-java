package com.as.java.design.mode.observer;

import java.util.Observable;

/**
 * @author as.
 * @since 2021/1/4
 */
public class WeatherStation extends Observable {

    public static void main(String[] args) {
        Integer a = 128;
        int b = 128;
        Integer c = new Integer(128);
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
    }
}
