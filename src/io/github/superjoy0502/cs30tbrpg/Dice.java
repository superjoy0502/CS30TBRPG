package io.github.superjoy0502.cs30tbrpg;

public class Dice {
    public static int roll(int rolls, int sides, int modifier) {
        int total = 0;
        for (int i = 0; i < rolls; i++) {
            total += (int) (Math.random() * sides) + 1;
        }
        total += modifier;
        return total;
    }
}
