package io.github.superjoy0502.cs30tbrpg.utilities;

import java.util.UUID;

public class Save {
    private String uuid;
    private String time;
    private String scenario;
    private String playerCharacter;
    private String position;
    // Constructor
    public Save(String uuid, String time, String scenario, String playerCharacter, String position) {
        this.uuid = uuid;
        this.time = time;
        this.scenario = scenario;
        this.playerCharacter = playerCharacter;
        this.position = position;
    }

    // Getters
    public String getUuid() {
        return uuid;
    }
    public String getTime() {
        return time;
    }

    public String getScenario() {
        return scenario;
    }

    public String getPlayerCharacter() {
        return playerCharacter;
    }

    public String getPosition() {
        return position;
    }
}
