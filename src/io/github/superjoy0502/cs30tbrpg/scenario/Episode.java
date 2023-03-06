package io.github.superjoy0502.cs30tbrpg.scenario;

import java.util.List;

public class Episode {
    private int id;
    private List<Dialogue> dialogues;
    private List<Choice> choices;

    public int getId() {
        return id;
    }

    public List<Dialogue> getDialogues() {
        return dialogues;
    }

    public List<Choice> getChoices() {
        return choices;
    }
}
