package com.as.java.design.mode.factory.none;

import com.as.java.design.mode.factory.normal.CakeFactoryA;
import com.as.java.design.mode.factory.normal.ICakeFactory;
import com.as.java.design.mode.factory.product.AbstractCake;
import com.as.java.design.mode.factory.product.CakeA;
import com.as.java.design.mode.factory.product.CakeB;

/**
 * desc: 蛋糕店使用蛋糕，在没有模式的情况下
 * author: as
 * date: 2019/5/22
 */
public class CakeShop {

    public static void main(String[] args) {
        AbstractCake a = new CakeA();
        AbstractCake b = new CakeB();
        a.showName();
        b.showName();
        /*
         缺点：
         1、直接实例化对象，这使得client对CakeA、CakeB的耦合程度过高
         2、如果CakeA、CakeB的实例化代码过于复杂，则会造成大量的冗余代码。且一旦实例化过程需要修改，
         每个实例化的地方都需要修改，违背的了开闭原则
         */
    }
}
