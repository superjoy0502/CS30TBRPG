package io.github.superjoy0502.cs30tbrpg.scenario;

public class Prompt {
    private int id;
    private String text;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void print() {
        System.out.println(id + ". " + text);
    }
}
