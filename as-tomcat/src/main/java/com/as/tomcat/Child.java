package com.as.tomcat;


public class Child extends Parent {

    @Override
    public void test() {
        super.test();
    }

    @Override
    protected void sayHello() {
        System.out.println("child say hello");
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.test();
    }
}
