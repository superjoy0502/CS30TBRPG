package io.github.superjoy0502.cs30tbrpg;

public class Character {
    public String name;
    public float height;
    public float weight;
    public String occupation;
    public String pronouns; // In the form of "he/him/his" or "she/her/hers"
    public String residence;
    public String birthplace;
    public int age;
    public String nationality;
//    private String era;

    public int strength;
    public int constitution;
    public int size;
    public int dexterity;
    public int appearance;
    public int intelligence;
    public int power;
    public int education;
    public int luck;

    public int hitPoints;
    public int magicPoints;
    public int sanityPoints;
    public int damageBonus;
    public int build;
    public int dodge;
    public int moveRate;

    public void rollStats(){
        strength = Dice.roll(3, 6, 0) * 5;
        constitution = Dice.roll(3, 6, 0) * 5;
        size = Dice.roll(2, 6, 6) * 5;
        education = Dice.roll(3, 6, 0) * 5;
        appearance = Dice.roll(3, 6, 0) * 5;
        dexterity = Dice.roll(3, 6, 0) * 5;
        intelligence = Dice.roll(2, 6, 6) * 5;
        power = Dice.roll(3, 6, 0) * 5;
        luck = Dice.roll(3, 6, 0) * 5;
    }
}
