package com.as.java.util.dota;

import java.util.Arrays;

/**
 * desc:
 * author: as
 * date: 2019/5/21
 */
public class Undying extends Hero {

    public Undying() {
        super();
        this.build("不朽尸王", "僵尸", "雄", "僵尸模型",
                "夜魇阵营的一名力量英雄。",
                Arrays.asList("腐朽", "噬魂", "墓碑", "血肉傀儡"));
    }

    public static void main(String[] args) {
        Undying hero = new Undying();
        System.out.println(hero);
    }
}
