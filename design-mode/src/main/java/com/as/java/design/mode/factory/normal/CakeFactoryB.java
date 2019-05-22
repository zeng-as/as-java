package com.as.java.design.mode.factory.normal;

import com.as.java.design.mode.factory.product.AbstractCake;
import com.as.java.design.mode.factory.product.CakeB;

/**
 * desc:
 * author: as
 * date: 2019/5/22
 */
public class CakeFactoryB implements ICakeFactory {
    @Override
    public AbstractCake makeCake() {
        return new CakeB();
    }
}
