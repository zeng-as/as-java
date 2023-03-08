package com.as.base.classLoader;

import java.lang.reflect.Method;

/**
 * @author as
 * @date 2022/11/17
 * @desc
 */
public class HotswapTest {

    public static void main(String[] args) throws Exception {
        final Hello hello = new Hello();
        System.out.println(hello.getClass().getClassLoader());
        loadHello();
    }

    public static void loadHello() throws Exception {
        MyClassLoader myLoader = new MyClassLoader();
        Class<?> class1 = myLoader
                .findClass( "com.as.base.classLoader.Hello");//Class instance
        Object obj1 = class1.newInstance();//Generate a new object
        Method method = class1.getMethod( "say");
        method.invoke(obj1);//Execute method say
        System. out.println(obj1.getClass());//Object
        System. out.println(obj1.getClass().getClassLoader());//Object class loader

    }
}
