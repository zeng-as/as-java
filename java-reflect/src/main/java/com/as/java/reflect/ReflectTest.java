package com.as.java.reflect;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * desc:
 * author: as
 * date: 2018/11/1 10:56
 */
public class ReflectTest {
    static class ClassA{
        // filed：域、属性

        private int fa;
        int fb;
        protected int fc;
        public int fd;

        // method：方法


        private void ca(){}
        protected void cc(){}
        void cb(){}
        @CallerSensitive
        public void cd(){}

        // constructor: 构造方法

        private ClassA(){}
        protected ClassA(int a){}
        ClassA(int a, int b){}
        public ClassA(int a, int b, int c){}
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Reflection.getCallerClass());
        Class a = ClassA.class;
        Class b = Class.forName("com.as.java.reflect.ReflectTest$ClassA");
        ClassA ca = new ClassA(1);
        Class c = ca.getClass();

        sout(a, ca);
//        sout(b, ca);
//        sout(c, ca);
    }

    public static void sout(Class clazz, Object o){
        System.out.println("输出：" + clazz.getName());

        // filed
        Field[] fs = clazz.getFields();
        Arrays.asList(fs).forEach(f -> {
            System.out.println(f);
            try {
                System.out.println(f.get(o));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        // method
        Method[] ms = clazz.getMethods();
        Arrays.asList(ms).forEach( m -> {
            System.out.println(m);
            System.out.println(m.getDeclaringClass().getClassLoader());
            System.out.println(Reflection.isCallerSensitive(m));
        });

        // constructor
        Constructor[] cs = clazz.getConstructors();
        Arrays.asList(cs).forEach(c -> {
            System.out.println(c);
        });

        // annotation

        System.out.println("");
    }
}
