package com.as.java.design.mode.factory.abstraction;

/**
 * desc:
 * author: as
 * date: 2019/5/22
 */
public class CakeShop {
    public static void main(String[] args) {
        IComboFactory factoryA = new ComboFactoryA();
        IComboFactory factoryB = new ComboFactoryB();
        factoryA.makeCake().showName();
        factoryB.makeCake().showName();
        factoryA.makeMilkyTea().showName();
        factoryB.makeMilkyTea().showName();
        /*
         抽象工厂模式：
         抽象工厂模式与工厂模式非常类似，只是抽象工厂模式中，工厂不会仅针对一个针对，而是增对多个产品
         */
    }
}
