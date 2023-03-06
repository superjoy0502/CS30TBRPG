package io.github.superjoy0502.cs30tbrpg.scenario;

public class Consequence extends Dialogue {
    private int id;

    public int getId() {
        return id;
    }

    @Override
    public String getSpeaker() {
        return "Narrator";
    }
}
