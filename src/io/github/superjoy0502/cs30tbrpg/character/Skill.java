package io.github.superjoy0502.cs30tbrpg.character;

import io.github.superjoy0502.cs30tbrpg.utilities.SkillType;

public class Skill {
    private SkillType type;
    private String option;
    private int value;

    public Skill(SkillType type, String option, int value) {
        this.type = type;
        this.option = option;
        this.value = value;
    }

    public Skill(SkillType type, int value) {
        this.type = type;
        this.option = null;
        this.value = value;
    }

    public SkillType getType() {
        return type;
    }

    public String getOption() {
        return option;
    }

    public int getValue() {
        return value;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
