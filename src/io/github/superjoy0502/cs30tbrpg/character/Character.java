package io.github.superjoy0502.cs30tbrpg.character;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.superjoy0502.cs30tbrpg.utilities.Dice;
import io.github.superjoy0502.cs30tbrpg.utilities.SuccessLevel;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
    protected int STR;
    protected int CON;
    protected int SIZ;
    protected int DEX;
    protected int APP;
    protected int INT;
    protected int POW;
    protected int EDU;
    protected int LUK;
    protected int HP;
    protected int maxHP;
    protected int MP;
    protected int maxMP;
    protected int SAN;
    protected int maxSAN;
    protected String damageBonus;
    protected ArrayList<Skill> skills = new ArrayList<Skill>() {{
        add(new Skill("Accounting", 5));
        add(new Skill("Acting", 5));
        add(new Skill("Animal Handling", 5));
        add(new Skill("Anthropology", 1));
        add(new Skill("Appraise", 5));
        add(new Skill("Archaeology", 1));
        add(new Skill("Artillery", 1));
        add(new Skill("Astronomy", 1));
        add(new Skill("Axe", 15));
        add(new Skill("Biology", 1));
        add(new Skill("Botany", 1));
        add(new Skill("Bow", 15));
        add(new Skill("Brawl", 25));
        add(new Skill("Chainsaw", 10));
        add(new Skill("Charm", 15));
        add(new Skill("Chemistry", 10));
        add(new Skill("Climb", 20));
        add(new Skill("Computer Use", 5));
        add(new Skill("Credit Rating", 0));
        add(new Skill("Cryptography", 1));
        add(new Skill("Cthulhu Mythos", 0));
        add(new Skill("Demolitions", 1));
        add(new Skill("Disguise", 5));
        add(new Skill("Diving", 1));
        add(new Skill("Dodge", 25));
        add(new Skill("Drive Auto", 20));
        add(new Skill("Electrical Repair", 10));
        add(new Skill("Electronics", 1));
        add(new Skill("Fast Talk", 5));
        add(new Skill("Fine Art", 5));
        add(new Skill("First Aid", 30));
        add(new Skill("Flail", 10));
        add(new Skill("Flamethrower", 10));
        add(new Skill("Forensics", 1));
        add(new Skill("Forgery", 5));
        add(new Skill("Garrote", 15));
        add(new Skill("Geology", 1));
        add(new Skill("Handgun", 20));
        add(new Skill("Heavy Weapons", 10));
        add(new Skill("History", 5));
        add(new Skill("Hypnosis", 1));
        add(new Skill("Intimidate", 15));
        add(new Skill("Jump", 20));
        add(new Skill("Language (Other)", "", 1));
        add(new Skill("Language (Own)", "", 50));
        add(new Skill("Law", 5));
        add(new Skill("Library Use", 20));
        add(new Skill("Listen", 20));
        add(new Skill("Locksmith", 1));
        add(new Skill("Lore", 1));
        add(new Skill("Machine Gun", 10));
        add(new Skill("Mathematics", 10));
        add(new Skill("Mechanical Repair", 10));
        add(new Skill("Medicine", 1));
        add(new Skill("Meteorology", 1));
        add(new Skill("Natural World", 10));
        add(new Skill("Navigate", 10));
        add(new Skill("Occult", 5));
        add(new Skill("Operate Heavy Machinery", 1));
        add(new Skill("Persuade", 10));
        add(new Skill("Pilot", "", 1));
        add(new Skill("Psychoanalysis", 1));
        add(new Skill("Psychology", 10));
        add(new Skill("Read Lips", 1));
        add(new Skill("Ride", 5));
        add(new Skill("Rifle/Shotgun", 25));
        add(new Skill("Sleight of Hand", 10));
        add(new Skill("Spear", 20));
        add(new Skill("Spot Hidden", 25));
        add(new Skill("Stealth", 20));
        add(new Skill("Submachine Gun", 15));
        add(new Skill("Survival", "", 10));
        add(new Skill("Sword", 20));
        add(new Skill("Swim", 20));
        add(new Skill("Throw", 20));
        add(new Skill("Track", 10));
        add(new Skill("Whip", 5));
        add(new Skill("Zoology", 1));
    }};

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
        Skill ownLang = getSkill("Language (Own)");
        if (ownLang != null) {
            ownLang.setValue(EDU);
        }
    }

    public void setStats(int STR, int CON, int SIZ, int DEX, int APP, int INT, int POW, int EDU, int LUK) {
        setStats(STR, CON, SIZ, DEX, APP, INT, POW, EDU, LUK, (CON + SIZ) / 10, POW / 5, POW);
    }

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

    private Skill getSkill(String skillName) {
        for (Skill skill : skills) {
            if (skill.getName().equals(skillName)) {
                return skill;
            }
        }
        return null;
    }

    public SuccessLevel roll(String target) {
        int roll = Dice.roll(1, 100);
        int value;
        switch (target) {
            case "STR":
                value = STR;
                break;
            case "CON":
                value = CON;
                break;
            case "SIZ":
                value = SIZ;
                break;
            case "DEX":
                value = DEX;
                break;
            case "APP":
                value = APP;
                break;
            case "INT":
                value = INT;
                break;
            case "POW":
                value = POW;
                break;
            case "EDU":
                value = EDU;
                break;
            case "LUK":
                value = LUK;
                break;
            default:
                Skill skill = getSkill(target);
                if (skill == null) {
                    throw new NullPointerException("Skill not found");
                }
                value = skill.getValue();
                break;
        }

        System.out.println("(1d100 <= " + value + ") Dice: " + roll);

        if (roll == 1) {
            System.out.println("Critical Success");
            return SuccessLevel.CRITICAL_SUCCESS;
        } else if (roll <= (value / 5)) {
            System.out.println("Extreme Success");
            return SuccessLevel.EXTREME_SUCCESS;
        } else if (roll <= (value / 2)) {
            System.out.println("Hard Success");
            return SuccessLevel.HARD_SUCCESS;
        } else if (roll <= value) {
            System.out.println("Regular Success");
            return SuccessLevel.SUCCESS;
        } else if (roll == 100) {
            System.out.println("Fumble");
            return SuccessLevel.FUMBLE;
        } else {
            System.out.println("Failure");
            return SuccessLevel.FAILURE;
        }
    }
}
