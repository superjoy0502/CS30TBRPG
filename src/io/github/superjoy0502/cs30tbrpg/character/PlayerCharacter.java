package io.github.superjoy0502.cs30tbrpg.character;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class PlayerCharacter extends Character{
    public static PlayerCharacter fromCharacter(Character character) {
        PlayerCharacter pc = new PlayerCharacter();
        pc.name = character.name;
        pc.height = character.height;
        pc.weight = character.weight;
        pc.occupation = character.occupation;
        pc.age = character.age;
        pc.sex = character.sex;
        pc.residence = character.residence;
        pc.birthplace = character.birthplace;
        pc.nationality = character.nationality;
        pc.STR = character.STR;
        pc.CON = character.CON;
        pc.SIZ = character.SIZ;
        pc.DEX = character.DEX;
        pc.APP = character.APP;
        pc.INT = character.INT;
        pc.POW = character.POW;
        pc.EDU = character.EDU;
        pc.LUK = character.LUK;
        pc.HP = character.HP;
        pc.maxHP = character.maxHP;
        pc.MP = character.MP;
        pc.maxMP = character.maxMP;
        pc.SAN = character.SAN;
        pc.maxSAN = character.maxSAN;
        pc.damageBonus = character.damageBonus;
        pc.skills = character.skills;

        return pc;
    }

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
