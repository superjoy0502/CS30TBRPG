package io.github.superjoy0502.cs30tbrpg.scenario;

public class Dialogue {
    private int id;
    private String speaker;
    private String text;
    private String roll;
    private String continueTo;

    public int getId() {
        return id;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getText() {
        return text;
    }

    public String getRoll() {
        return roll;
    }

    public String getContinueTo() {
        return continueTo;
    }

    public void print() {
        System.out.println(speaker + ": " + text);
        System.out.println();
    }
}
