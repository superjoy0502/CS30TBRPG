package io.github.superjoy0502.cs30tbrpg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        // Regex for dice command
        final String regex =
                "^(([+]?|-)(([1-9][0-9]*d[1-9][0-9]*)|([0-9]+))+)+(([+]|-)(([1-9][0-9]*d[1-9][0-9]*)|([0-9]+))+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(commandWithoutSpaces);

        if (matcher.matches()) {
            List<String> commands = splitDiceCommand(commandWithoutSpaces);
            int total = 0;
            for (int i = 0; i < commands.size(); i++) {
                String command = commands.get(i);
                if (command.equals("+") || command.equals("-")) continue;
                if (command.contains("d")) {
                    String[] commandSplit = command.split("d");
                    int rolls = Integer.parseInt(commandSplit[0]);
                    int sides = Integer.parseInt(commandSplit[1]);
                    if (i == 0) continue;
                    if (commands.get(i - 1).equals("-")) {
                        total -= roll(rolls, sides);
                    } else {
                        total += roll(rolls, sides);
                    }
                } else {
                    if (i == 0) continue;
                    if (commands.get(i - 1).equals("-")) {
                        total -= Integer.parseInt(command);
                    } else {
                        total += Integer.parseInt(command);
                    }
                }
            }
            return total;
        } else {
            return -1;
        }
    }

    private static List<String> splitDiceCommand(String input) {
        List<String> commands = Arrays.asList(input.split("([+]|-)"));
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < commands.size(); i++) {
            result.add(commands.get(0));
            result.add(String.valueOf(input.charAt(commands.get(0).length())));
            commands.remove(0);
        }
        return result;
    }
}
