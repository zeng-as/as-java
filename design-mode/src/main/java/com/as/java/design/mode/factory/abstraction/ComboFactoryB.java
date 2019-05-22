package com.as.java.design.mode.factory.abstraction;

import com.as.java.design.mode.factory.product.AbstractCake;
import com.as.java.design.mode.factory.product.BaseMilkyTea;
import com.as.java.design.mode.factory.product.CakeB;
import com.as.java.design.mode.factory.product.MilkyTeaB;

/**
 * desc:
 * author: as
 * date: 2019/5/22
 */
public class ComboFactoryB implements IComboFactory {
    @Override
    public AbstractCake makeCake() {
        return new CakeB();
    }

    @Override
    public BaseMilkyTea makeMilkyTea() {
        return new MilkyTeaB();
    }
}
