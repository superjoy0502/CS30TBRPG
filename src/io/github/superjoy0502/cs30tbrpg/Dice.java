package io.github.superjoy0502.cs30tbrpg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dice {
    public static int roll(int rolls, int sides, int modifier) {
        int total = 0;
        for (int i = 0; i < rolls; i++) {
            total += (int) (Math.random() * sides) + 1;
        }
        total += modifier;
        return total;
    }

    public static int roll(int rolls, int sides) {
        return roll(rolls, sides, 0);
    }

    public static int roll(String input) {
        String commandWithoutSpaces = input.replaceAll("\\s", "").toLowerCase();
        final String regex = "^[1-9][0-9]*d[1-9][0-9]*([+](([1-9][0-9]*d[1-9][0-9]*)|([0-9]+))+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(commandWithoutSpaces);

        if (matcher.matches()) {
            String[] commands = commandWithoutSpaces.split("[+]");
            int total = 0;
            for (String command : commands) {
                if (command.contains("d")) {
                    String[] commandSplit = command.split("d");
                    int rolls = Integer.parseInt(commandSplit[0]);
                    int sides = Integer.parseInt(commandSplit[1]);
                    total += roll(rolls, sides);
                } else {
                    total += Integer.parseInt(command);
                }
            }
            return total;
        } else {
            return -1;
        }
    }
}
