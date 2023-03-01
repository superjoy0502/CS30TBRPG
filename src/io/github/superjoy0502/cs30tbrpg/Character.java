package io.github.superjoy0502.cs30tbrpg;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Character {
    public Character() {}

    public Character(List<String> stats) {
        load(stats);
    }

    public String name;
    public String height;
    public String weight;
    public String occupation;
    public int age;
    public String sex;
    public String residence;
    public String birthplace;
    public String nationality;

    private int STR;
    private int CON;
    private int SIZ;
    private int DEX;
    private int APP;
    private int INT;
    private int POW;
    private int EDU;
    private int LUK;

    private int HP;
    private int maxHP;
    private int MP;
    private int maxMP;
    private int SAN;
    private int maxSAN;
    private String damageBonus;

    public void setStats(int STR, int CON, int SIZ, int DEX, int APP, int INT, int POW, int EDU, int LUK, int HP, int MP, int SAN) {
        this.STR = STR;
        this.CON = CON;
        this.SIZ = SIZ;
        this.DEX = DEX;
        this.APP = APP;
        this.INT = INT;
        this.POW = POW;
        this.EDU = EDU;
        this.LUK = LUK;

        int STRSIZ = this.STR + this.SIZ;
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

        maxHP = (this.CON + this.SIZ) / 10;
        this.HP = HP;
        maxMP = this.POW / 5;
        this.MP = MP;
        maxSAN = this.POW;
        this.SAN = SAN;
    }

    public void setStats(int STR, int CON, int SIZ, int DEX, int APP, int INT, int POW, int EDU, int LUK) {
        setStats(STR, CON, SIZ, DEX, APP, INT, POW, EDU, LUK, (CON + SIZ) / 10, POW / 5, POW);
    }

    private String convertToCSV() {
        return Stream.of(name, height, weight, occupation, age, sex, residence, birthplace, nationality,
                        STR, CON, SIZ, DEX, APP, INT, POW, EDU, LUK,
                        HP, MP, SAN)
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
            System.out.println("Error saving character: " + e.getMessage());
        }
    }

    private void load(List<String> stats) {
        for (int i = 0; i < 9; i++) {
            switch (i) {
                case 0:
                    name = stats.get(i);
                    break;
                case 1:
                    height = stats.get(i);
                    break;
                case 2:
                    weight = stats.get(i);
                    break;
                case 3:
                    occupation = stats.get(i);
                    break;
                case 4:
                    age = Integer.parseInt(stats.get(i));
                    break;
                case 5:
                    sex = stats.get(i);
                    break;
                case 6:
                    residence = stats.get(i);
                    break;
                case 7:
                    birthplace = stats.get(i);
                    break;
                case 8:
                    nationality = stats.get(i);
                    break;
            }
        }
        setStats(
                Integer.parseInt(stats.get(9)),
                Integer.parseInt(stats.get(10)),
                Integer.parseInt(stats.get(11)),
                Integer.parseInt(stats.get(12)),
                Integer.parseInt(stats.get(13)),
                Integer.parseInt(stats.get(14)),
                Integer.parseInt(stats.get(15)),
                Integer.parseInt(stats.get(16)),
                Integer.parseInt(stats.get(17)),
                Integer.parseInt(stats.get(18)),
                Integer.parseInt(stats.get(19)),
                Integer.parseInt(stats.get(20))
        );
    }
}
