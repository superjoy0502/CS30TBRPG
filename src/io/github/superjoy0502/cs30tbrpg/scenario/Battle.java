package io.github.superjoy0502.cs30tbrpg.scenario;

import io.github.superjoy0502.cs30tbrpg.character.Character;
import io.github.superjoy0502.cs30tbrpg.utilities.Dice;
import io.github.superjoy0502.cs30tbrpg.utilities.SuccessLevel;

import java.util.List;

public class Battle {
    private int id;
    private List<Character> enemies;
    private List<Character> allies; // The 0th element of this list is always the player character
    
    private int getTotalDamage(int damage, String damageBonus) {
    	return damage + Dice.roll(damageBonus);
    }
    
    private boolean dodgeSuccess(SuccessLevel attackLevel, SuccessLevel dodgeLevel) {
    	if (attackLevel.ordinal() > dodgeLevel.ordinal()) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
    private void decreaseHP(Character character, int value){
    	character.HP -= value;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Battle().getTotalDamage(0, "1d4"));
    }
}
