package io.github.superjoy0502.cs30tbrpg.scenario;

import io.github.superjoy0502.cs30tbrpg.character.Character;

import java.util.List;

public class Scenario {
    private String title;
    private List<Character> characters;
    private List<Episode> episodes;

    public String getTitle() {
        return title;
    }
    public List<Character> getCharacters() {
        return characters;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }
}
