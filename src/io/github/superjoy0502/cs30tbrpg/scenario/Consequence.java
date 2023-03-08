package io.github.superjoy0502.cs30tbrpg.scenario;

public class Consequence extends Dialogue {
    @Override
    public String getSpeaker() {
        if (super.getSpeaker() == null) {
            return "Narrator";
        } else {
            return super.getSpeaker();
        }
    }
}
