package io.github.superjoy0502.cs30tbrpg.character;

public class Skill {
    private String name;
    private String option;
    private int value;

    public Skill(String name, String option, int value) {
        this.name = name;
        this.option = option;
        this.value = value;
    }

    public Skill(String name, int value) {
        this.name = name;
        this.option = null;
        this.value = value;
    }

    public String getName() {
        return name;
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
