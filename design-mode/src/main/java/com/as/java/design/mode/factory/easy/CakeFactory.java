package com.as.java.design.mode.factory.easy;

import com.as.java.design.mode.factory.product.AbstractCake;
import com.as.java.design.mode.factory.product.CakeA;
import com.as.java.design.mode.factory.product.CakeB;

/**
 * desc:
 * author: as
 * date: 2019/5/22
 */
public class CakeFactory {

    public static AbstractCake makeCake(String type) {
        if ("A".equals(type)) {
            return new CakeA();
        } else if ("B".equals(type)) {
            return new CakeB();
        } else {
            return null;
        }
    }
}
