package com.as.base.annotation;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/**
 * @author as
 * @date 2022/9/1
 * @desc
 */
public class CallerSensitiveTest {


    @CallerSensitive
    public static void withCallerSensitive() {
        System.out.format("Method is called by %s%n",Reflection.getCallerClass());
    }

    /*无注解直接调用*/
    public static void noCallerSensitive() {
        System.out.format("Method is called by %s%n", Reflection.getCallerClass());
    }

    public static void main(String[] args) {
        withCallerSensitive();
        noCallerSensitive();
        int[] a = {1,2,3};
    }
}
