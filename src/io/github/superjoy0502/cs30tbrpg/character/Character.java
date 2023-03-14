package io.github.superjoy0502.cs30tbrpg.character;

import io.github.superjoy0502.cs30tbrpg.utilities.Dice;
import io.github.superjoy0502.cs30tbrpg.utilities.SkillType;
import io.github.superjoy0502.cs30tbrpg.utilities.SuccessLevel;

import java.util.ArrayList;

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
        add(new Skill(SkillType.ACCOUNTING, 5));
        add(new Skill(SkillType.ACTING, 5));
        add(new Skill(SkillType.ANIMAL_HANDLING, 5));
        add(new Skill(SkillType.ANTRHROPOLOGY, 1));
        add(new Skill(SkillType.APPRAISE, 5));
        add(new Skill(SkillType.ARCHAEOLOGY, 1));
        add(new Skill(SkillType.ARTILLERY, 1));
        add(new Skill(SkillType.ASTRONOMY, 1));
        add(new Skill(SkillType.AXE, 15));
        add(new Skill(SkillType.BIOLOGY, 1));
        add(new Skill(SkillType.BOTANY, 1));
        add(new Skill(SkillType.BOW, 15));
        add(new Skill(SkillType.BRAWL, 25));
        add(new Skill(SkillType.CHAINSAW, 10));
        add(new Skill(SkillType.CHARM, 15));
        add(new Skill(SkillType.CHEMISTRY, 10));
        add(new Skill(SkillType.CLIMB, 20));
        add(new Skill(SkillType.COMPUTER_USE, 5));
        add(new Skill(SkillType.CREDIT_RATING, 0));
        add(new Skill(SkillType.CRYPTOGRAPHY, 1));
        add(new Skill(SkillType.CTHULHU_MYTHOS, 0));
        add(new Skill(SkillType.DEMOLITIONS, 1));
        add(new Skill(SkillType.DISGUISE, 5));
        add(new Skill(SkillType.DIVING, 1));
        add(new Skill(SkillType.DODGE, 25));
        add(new Skill(SkillType.DRIVE_AUTO, 20));
        add(new Skill(SkillType.ELECTRICAL_REPAIR, 10));
        add(new Skill(SkillType.ELECTRONICS, 1));
        add(new Skill(SkillType.FAST_TALK, 5));
        add(new Skill(SkillType.FINE_ART, 5));
        add(new Skill(SkillType.FIRST_AID, 30));
        add(new Skill(SkillType.FLAIL, 10));
        add(new Skill(SkillType.FLAME_THROWER, 10));
        add(new Skill(SkillType.FORENSICS, 1));
        add(new Skill(SkillType.FORGERY, 5));
        add(new Skill(SkillType.GARROTTE, 15));
        add(new Skill(SkillType.GEOLOGY, 1));
        add(new Skill(SkillType.HANDGUN, 20));
        add(new Skill(SkillType.HEAVY_WEAPONS, 10));
        add(new Skill(SkillType.HISTORY, 5));
        add(new Skill(SkillType.HYPNOSIS, 1));
        add(new Skill(SkillType.INTIMIDATE, 15));
        add(new Skill(SkillType.JUMP, 20));
        add(new Skill(SkillType.LANGUAGE_OTHER, "", 1));
        add(new Skill(SkillType.LANGUAGE_OWN, "", 50));
        add(new Skill(SkillType.LAW, 5));
        add(new Skill(SkillType.LIBRARY_USE, 20));
        add(new Skill(SkillType.LISTEN, 20));
        add(new Skill(SkillType.LOCKSMITH, 1));
        add(new Skill(SkillType.LORE, 1));
        add(new Skill(SkillType.MACHINE_GUN, 10));
        add(new Skill(SkillType.MATHEMATICS, 10));
        add(new Skill(SkillType.MECHANICAL_REPAIR, 10));
        add(new Skill(SkillType.MEDICINE, 1));
        add(new Skill(SkillType.METEOROLOGY, 1));
        add(new Skill(SkillType.NATURAL_WORLD, 10));
        add(new Skill(SkillType.NAVIGATE, 10));
        add(new Skill(SkillType.OCCULT, 5));
        add(new Skill(SkillType.OPERATE_HEAVY_MACHINERY, 1));
        add(new Skill(SkillType.PERSUADE, 10));
        add(new Skill(SkillType.PILOT, "", 1));
        add(new Skill(SkillType.PSYCHOANALYSIS, 1));
        add(new Skill(SkillType.PSYCHOLOGY, 10));
        add(new Skill(SkillType.READ_LIPS, 1));
        add(new Skill(SkillType.RIDE, 5));
        add(new Skill(SkillType.RIFLE_SHOTGUN, 25));
        add(new Skill(SkillType.SLEIGHT_OF_HAND, 10));
        add(new Skill(SkillType.SPEAR, 20));
        add(new Skill(SkillType.SPOT_HIDDEN, 25));
        add(new Skill(SkillType.STEALTH, 20));
        add(new Skill(SkillType.SUBMACHINE_GUN, 15));
        add(new Skill(SkillType.SURVIVAL, "", 10));
        add(new Skill(SkillType.SWORD, 20));
        add(new Skill(SkillType.SWIM, 20));
        add(new Skill(SkillType.THROW, 20));
        add(new Skill(SkillType.TRACK, 10));
        add(new Skill(SkillType.WHIP, 5));
        add(new Skill(SkillType.ZOOLOGY, 1));
    }};

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
        maxSAN = 99 - getSkill(SkillType.CTHULHU_MYTHOS).getValue();
        this.SAN = SAN;
        Skill ownLang = getSkill(SkillType.LANGUAGE_OWN);
        if (ownLang != null) {
            ownLang.setValue(EDU);
        }
    }

    public void setStats(int STR, int CON, int SIZ, int DEX, int APP, int INT, int POW, int EDU, int LUK) {
        setStats(STR, CON, SIZ, DEX, APP, INT, POW, EDU, LUK, (CON + SIZ) / 10, POW / 5, POW);
    }

    public void save() { }

    private Skill getSkill(SkillType skillType) {
        /*// Linear search
        for (Skill skill : skills) {
            if (skill.getType().equals(skillType)) {
                return skill;
            }
        }*/

        // Binary search
        int low = 0;
        int high = skills.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            Skill skill = skills.get(mid);
            if (skill.getType().equals(skillType)) {
                return skill;
            } else if (skill.getType().compareTo(skillType) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public SuccessLevel roll(SkillType skillType) {
        return roll(skillType.toString());
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
                Skill skill = getSkill(SkillType.fromString(target));
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
