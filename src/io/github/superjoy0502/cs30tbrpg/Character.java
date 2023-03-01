package io.github.superjoy0502.cs30tbrpg;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

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
    private List<Skill> skills;

    public Character() { }

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

    public void save() {
        try (Writer writer = new FileWriter("resources/characters.json", true)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
