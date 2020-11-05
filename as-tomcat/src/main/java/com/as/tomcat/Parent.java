package com.as.tomcat;

public class Parent {

    public void test() {
        this.sayHello();
    }

    protected void sayHello() {
        System.out.println("parent say hello");
    }
}
