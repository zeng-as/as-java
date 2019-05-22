package com.as.java.util.dota;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * desc: dota hero 抽象类
 * author: as
 * date: 2019/5/21
 */
@Getter
@ToString
public abstract class Hero {

    // 名称
    protected String name;

    // 种族
    protected String race;

    // 性别（雌、雄、雌雄同体）
    protected String sex;

    // 模型
    protected String model;

    // 背景
    protected String background;

    // 技能
    protected List<String> skills;

    public Hero() {
    }

    protected void build(String name, String race, String sex, String model, String background, List<String> skills) {
        this.name = name;
        this.race = race;
        this.sex = sex;
        this.model = model;
        this.background = background;
        this.skills = skills;
    }
}
