package io.github.superjoy0502.cs30tbrpg.scenario;

import io.github.superjoy0502.cs30tbrpg.character.Character;
import io.github.superjoy0502.cs30tbrpg.utilities.Dice;
import io.github.superjoy0502.cs30tbrpg.utilities.SuccessLevel;

import java.util.List;

public class Battle {
    private int id;
    private List<Character> enemies;
    private List<Character> allies; // The 0th element of this list is always the player character
    private String continueTo;

    /*public boolean battle() {
        boolean playerWin = true;
        while (enemies.size() > 0 && allies.size() > 0) {
            for (Character enemy : enemies) {
                if (allies.size() == 0) {
                    playerWin = false;
                    break;
                }
                Character ally = allies.get(0);
                int damage = getTotalDamage(enemy.getDamage(), enemy.getDamageBonus());
                SuccessLevel attackLevel = Dice.rollSuccessLevel(enemy.getAttack());
                SuccessLevel dodgeLevel = Dice.rollSuccessLevel(ally.getDodge());
                if (dodgeSuccess(attackLevel, dodgeLevel)) {
                    System.out.println(enemy.getName() + " attacks " + ally.getName() + " but misses!");
                } else {
                    System.out.println(enemy.getName() + " attacks " + ally.getName() + " and deals " + damage + " damage!");
                    decreaseHP(ally, damage);
                    if (ally.HP <= 0) {
                        allies.remove(ally);
                        System.out.println(ally.getName() + " has been defeated!");
                    }
                }
            }
            for (Character ally : allies) {
                if (enemies.size() == 0) {
                    break;
                }
                Character enemy = enemies.get(0);
                int damage = getTotalDamage(ally.getDamage(), ally.getDamageBonus());
                SuccessLevel attackLevel = Dice.rollSuccessLevel(ally.getAttack());
                SuccessLevel dodgeLevel = Dice.rollSuccessLevel(enemy.getDodge());
                if (dodgeSuccess(attackLevel, dodgeLevel)) {
                    System.out.println(ally.getName() + " attacks " + enemy.getName() + " but misses!");
                } else {
                    System.out.println(ally.getName() + " attacks " + enemy.getName() + " and deals " + damage + " damage!");
                    decreaseHP(enemy, damage);
                    if (enemy.HP <= 0) {
                        enemies.remove(enemy);
                        System.out.println(enemy.getName() + " has been defeated!");
                    }
                }
            }
        }
        return playerWin;
    }*/
    
    private int getTotalDamage(int damage, String damageBonus) {
    	return damage + Dice.roll(damageBonus);
    }
    
    private boolean dodgeSuccess(SuccessLevel attackLevel, SuccessLevel dodgeLevel) {
        return attackLevel.ordinal() <= dodgeLevel.ordinal();
    }
    
    private void decreaseHP(Character character, int value){
    	character.HP -= value;
    }
}
