package io.github.superjoy0502.cs30tbrpg.scenario;

import java.util.List;

public class Choice {
    private int id;
    private List<Prompt> prompts;
    private List<Consequence> consequences;

    public int getId() {
        return id;
    }

    public List<Prompt> getPrompts() {
        return prompts;
    }

    public List<Consequence> getConsequences() {
        return consequences;
    }

    public void print() {
        for (Prompt prompt : prompts) {
            prompt.print();
        }
    }
}
