package com.as.java.design.mode.factory.easy;

import com.as.java.design.mode.factory.product.AbstractCake;

/**
 * desc:
 * author: as
 * date: 2019/5/22
 */
public class CakeShop {

    public static void main(String[] args) {
        AbstractCake a = CakeFactory.makeCake("A");
        AbstractCake b = CakeFactory.makeCake("B");
        a.showName();
        b.showName();
        /*
         优点：
         1、client对对象的耦合性降低了
         2、减少了重复的实例化代码
         3、当实例化方法修改时，仅需要修改factory中的make方法即可。
         缺点：
         1、当增加产品时，还是得修改factory中的make方法，违背了开闭原则，这个就引申出了工厂模式的出现。
         */
    }
}
