package com.as.java.design.mode.factory.abstraction;

import com.as.java.design.mode.factory.product.AbstractCake;
import com.as.java.design.mode.factory.product.BaseMilkyTea;

/**
 * desc:
 * author: as
 * date: 2019/5/22
 */
public interface IComboFactory {

    AbstractCake makeCake();

    BaseMilkyTea makeMilkyTea();
}
