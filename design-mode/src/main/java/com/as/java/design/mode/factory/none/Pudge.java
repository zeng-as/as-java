package com.as.java.design.mode.factory.none;

import lombok.ToString;

import java.util.Arrays;

/**
 * desc: 屠夫
 * author: as
 * date: 2019/5/21
 */
public class Pudge extends Hero {

    public Pudge() {
        super();
        this.build("屠夫", "人族", "雄", "屠夫模型",
                "天灾军团的一名力量型英雄，位于黑夜酒馆。",
                Arrays.asList("肉钩", "腐烂", "堆积腐肉", "肢解"));
    }

    public static void main(String[] args) {
        Pudge hero = new Pudge();
        System.out.println(hero);
    }
}
