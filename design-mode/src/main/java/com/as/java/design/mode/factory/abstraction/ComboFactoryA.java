package com.as.java.design.mode.factory.abstraction;

import com.as.java.design.mode.factory.product.AbstractCake;
import com.as.java.design.mode.factory.product.BaseMilkyTea;
import com.as.java.design.mode.factory.product.CakeA;
import com.as.java.design.mode.factory.product.MilkyTeaA;

/**
 * desc:
 * author: as
 * date: 2019/5/22
 */
public class ComboFactoryA implements IComboFactory {
    @Override
    public AbstractCake makeCake() {
        return new CakeA();
    }

    @Override
    public BaseMilkyTea makeMilkyTea() {
        return new MilkyTeaA();
    }
}
