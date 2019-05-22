package com.as.java.design.mode.factory.normal;

/**
 * desc:
 * author: as
 * date: 2019/5/22
 */
public class CakeShop {
    public static void main(String[] args) {
        ICakeFactory factoryA = new CakeFactoryA();
        ICakeFactory factoryB = new CakeFactoryB();
        factoryA.makeCake().showName();
        factoryB.makeCake().showName();
        /*
         工厂模式：
         优点：
         在简单工厂模式的基础上，修改了factory的实现。增加了factory抽象类，当增加产品时，通过增加对应factory实现应对其扩展。
         缺点：
         当种类无限多时，也需要增加对应数量的factory实现类数量，增加项目中类的数量。
         */
    }
}
