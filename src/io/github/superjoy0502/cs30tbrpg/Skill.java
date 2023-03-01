package io.github.superjoy0502.cs30tbrpg;

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
        this.value = value;
        this.option = "none";
    }
}
