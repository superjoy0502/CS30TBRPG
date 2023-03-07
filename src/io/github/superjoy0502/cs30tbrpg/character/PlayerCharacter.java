package io.github.superjoy0502.cs30tbrpg.character;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class PlayerCharacter extends Character{
    @Override
    public void save() {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Character>>(){}.getType();
        try {
            List<Character> characters = gson.fromJson(new FileReader("resources/characters.json"), type);
            characters.add(this);
            gson.toJson(characters, new FileWriter("resources/characters.json"));
        } catch (IOException e) {
            System.out.println("Error saving character. Please try again.");
        }
    }
}
