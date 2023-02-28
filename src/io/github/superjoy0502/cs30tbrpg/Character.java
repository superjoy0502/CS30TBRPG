package io.github.superjoy0502.cs30tbrpg;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Character {
    public String name;
    public String height;
    public String weight;
    public String occupation;
    public int age;
    public String sex;
    public String residence;
    public String birthplace;
    public String nationality;

    private int strength;
    private int constitution;
    private int size;
    private int dexterity;
    private int appearance;
    private int intelligence;
    private int power;
    private int education;
    private int luck;

    private int hitPoints;
    private int magicPoints;
    private int sanity;
    private String damageBonus;
    private int dodge;

    public void setStats(int STR, int CON, int SIZ, int DEX, int APP, int INT, int POW, int EDU, int LUK) {
        this.strength = STR;
        this.constitution = CON;
        this.size = SIZ;
        this.dexterity = DEX;
        this.appearance = APP;
        this.intelligence = INT;
        this.power = POW;
        this.education = EDU;
        this.luck = LUK;

        int STRSIZ = strength + size;
        if (STRSIZ < 65) {
            damageBonus = "-2";
        } else if (STRSIZ < 85) {
            damageBonus = "-1";
        } else if (STRSIZ < 125) {
            damageBonus = "0";
        } else if (STRSIZ < 165) {
            damageBonus = "1d4";
        } else if (STRSIZ < 205) {
            damageBonus = "1d6";
        } else if (STRSIZ < 285) {
            damageBonus = "2d6";
        } else if (STRSIZ < 365) {
            damageBonus = "3d6";
        } else if (STRSIZ < 445) {
            damageBonus = "4d6";
        } else {
            damageBonus = "5d6";
        }

        hitPoints = (constitution + size) / 10;
        magicPoints = power / 5;
        sanity = power;
        dodge = dexterity / 2;
    }

    private String convertToCSV() {
        return Stream.of(name, height, weight, occupation, age, sex, residence, birthplace, nationality,
                        strength, constitution, size, dexterity, appearance, intelligence, power, education, luck,
                        hitPoints, magicPoints, sanity)
                .map(String::valueOf)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    private String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public void save() {
        File csvOutputFile = new File("resources/characters.csv");
        // Append the result of convertToCSV() to the csvOutputFile
        try (PrintWriter pw = new PrintWriter(new FileWriter(csvOutputFile, true))) {
            pw.println(convertToCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
