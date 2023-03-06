package io.github.superjoy0502.cs30tbrpg.scenario;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class ScenarioOutline {
    private String title;
    private String description;
    private String author;
    private String translator;
    private String link;
    private int runtime;
    private List<String> tags;
    private String filename;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getTranslator() {
        return translator;
    }

    public String getLink() {
        return link;
    }

    public int getRuntime() {
        return runtime;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getFilename() {
        return filename;
    }

    public Scenario getScenario() {
        Gson gson = new Gson();
        Type type = new TypeToken<Scenario>(){}.getType();
        try {
            return gson.fromJson(new FileReader("resources/scenarios/" + filename + ".json"), type);
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
