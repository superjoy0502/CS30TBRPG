package io.github.superjoy0502.cs30tbrpg.character;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class PlayerCharacter extends Character{
    @Override
    public void save() {
        Type type = new TypeToken<List<Character>>(){}.getType();
        try (Reader reader = new FileReader("resources/characters.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            List<Character> characters = gson.fromJson(reader, type);
            characters.add(this);
            Writer writer = new FileWriter("resources/characters.json");
            gson.toJson(characters, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving character. Please try again.");
        }
    }
}
