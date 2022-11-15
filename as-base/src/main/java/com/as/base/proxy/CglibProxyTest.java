package com.as.base.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author as
 * @date 2022/9/2
 * @desc
 */
public class CglibProxyTest {

    public static class Student {
        public void name(String name) {
            System.out.println("我叫"+name);
        }

        public void age(int age) {
            System.out.println("我今年"+age+"岁");
        }
    }

    public static class MyInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("切面开始");
            methodProxy.invokeSuper(o, objects);
            System.out.println("切面结束");
            return null;
        }
    }


    public static void main(String[] args) {
        Student student = new Student();
        Student stu = (Student) Enhancer.create(student.getClass(), new MyInterceptor());
        stu.name("张三");
        stu.age(18);
    }
}
