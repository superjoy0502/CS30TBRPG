package io.github.superjoy0502.cs30tbrpg;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        final String os = System.getProperty("os.name");
        String clear = "";
        if (os.contains("Windows")) {
            clear = "cls";
        } else {
            clear = "clear";
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Call of Cthulhu 7th Modified Edition Text-Based RPG.");
        System.out.println("Menu");
        System.out.println("1. Create a character");
        System.out.println("2. Load a character");
        System.out.println("3. Exit");
        start(scanner);
    }

    private static void start(Scanner scanner) {
        // Text-based RPG
        System.out.print("Please enter a number >> ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input.");
            start(scanner);
            return;
        }
        switch (choice) {
            case 1:
                // Create a character
                Character character = new Character();
                System.out.print("Please enter your character's name >> ");
                character.name = scanner.nextLine();
                while (true) {
                    System.out.print("Please enter your character's height >> ");
                    String tempHeight = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
                    if (Pattern.compile("[1-9][0-9]*cm").matcher(tempHeight).matches() ||
                            Pattern.compile("[1-9][0-9]*ft[0-9]*in").matcher(tempHeight).matches() ||
                            Pattern.compile("[1-9][0-9]*ft").matcher(tempHeight).matches() ||
                            Pattern.compile("[1-9][0-9]*in").matcher(tempHeight).matches() ||
                            Pattern.compile("[1-9][0-9]*'[1-9][0-9]*\"").matcher(tempHeight).matches() ||
                            Pattern.compile("[1-9][0-9]*'").matcher(tempHeight).matches() ||
                            Pattern.compile("[1-9][0-9]*\"").matcher(tempHeight).matches()) {
                        character.height = tempHeight;
                        break;
                    } else {
                        System.out.println("Invalid input.");
                    }
                }
                while (true) {
                    System.out.print("Please enter your character's weight >> ");
                    String tempWeight = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
                    if (Pattern.compile("[1-9][0-9]*kg").matcher(tempWeight).matches() ||
                            Pattern.compile("[1-9][0-9]*lb").matcher(tempWeight).matches() ||
                            Pattern.compile("[1-9][0-9]*lbs").matcher(tempWeight).matches()) {
                        character.weight = tempWeight;
                        break;
                    } else {
                        System.out.println("Invalid input.");
                    }
                }
                System.out.print("Please enter your character's occupation >> ");
                character.occupation = scanner.nextLine();
                while (true) {
                    System.out.print("Please enter your character's age (Min 15, Max 89) >> ");
                    try {
                        character.age = Integer.parseInt(scanner.nextLine());
                        if (character.age < 15 || character.age > 89) {
                            System.out.println("Invalid input.");
                            continue;
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input.");
                    }
                }
                while (true) {
                    System.out.print("Please enter your character's sex (M/F) >> ");
                    character.sex = scanner.nextLine().toLowerCase();
                    if (character.sex.equals("m") || character.sex.equals("f")) {
                        break;
                    } else {
                        System.out.println("Invalid input.");
                    }
                }
                System.out.print("Please enter your character's residence >> ");
                character.residence = scanner.nextLine();
                System.out.print("Please enter your character's birthplace >> ");
                character.birthplace = scanner.nextLine();
                System.out.print("Please enter your character's nationality >> ");
                character.nationality = scanner.nextLine();

                while (true) {
                    System.out.println("========================================");
                    System.out.println("1. Name: " + character.name);
                    System.out.println("2. Height: " + character.height);
                    System.out.println("3. Weight: " + character.weight);
                    System.out.println("4. Occupation: " + character.occupation);
                    System.out.println("5. Age: " + character.age);
                    System.out.println("6. Sex: " + character.sex);
                    System.out.println("7. Residence: " + character.residence);
                    System.out.println("8. Birthplace: " + character.birthplace);
                    System.out.println("9. Nationality: " + character.nationality);
                    System.out.print("Does this look correct? (Y/N) >> ");
                    String confirm;
                    while (true) {
                        confirm = scanner.nextLine();
                        if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("n")) {
                            break;
                        }
                        System.out.print("Invalid input. Please enter Y or N >> ");
                    }
                    if (confirm.equals("n")) {
                        int field;
                        while (true) {
                            System.out.print("Please enter the number of the field you would like to change >> ");
                            try {
                                field = Integer.parseInt(scanner.nextLine());
                                if (field < 0 || field > 9) {
                                    System.out.println("Invalid input.");
                                    continue;
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid input.");
                            }
                        }
                        switch (field) {
                            case 1:
                                System.out.print("Please enter your character's name >> ");
                                character.name = scanner.nextLine();
                                break;
                            case 2:
                                while (true) {
                                    System.out.print("Please enter your character's height >> ");
                                    String tempHeight = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
                                    if (Pattern.compile("[1-9][0-9]*cm", Pattern.CASE_INSENSITIVE).matcher(tempHeight).matches() ||
                                            Pattern.compile("[1-9][0-9]*ft[0-9]*in", Pattern.CASE_INSENSITIVE).matcher(tempHeight).matches() ||
                                            Pattern.compile("[1-9][0-9]*ft", Pattern.CASE_INSENSITIVE).matcher(tempHeight).matches() ||
                                            Pattern.compile("[1-9][0-9]*in", Pattern.CASE_INSENSITIVE).matcher(tempHeight).matches() ||
                                            Pattern.compile("[1-9][0-9]*'[1-9][0-9]\"", Pattern.CASE_INSENSITIVE).matcher(tempHeight).matches() ||
                                            Pattern.compile("[1-9][0-9]*'", Pattern.CASE_INSENSITIVE).matcher(tempHeight).matches() ||
                                            Pattern.compile("[1-9][0-9]*\"", Pattern.CASE_INSENSITIVE).matcher(tempHeight).matches()) {
                                        character.height = tempHeight;
                                        break;
                                    } else {
                                        System.out.println("Invalid input.");
                                    }
                                }
                                break;
                            case 3:
                                while (true) {
                                    System.out.print("Please enter your character's weight >> ");
                                    String tempWeight = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
                                    if (Pattern.compile("[1-9][0-9]*kg").matcher(tempWeight).matches() ||
                                            Pattern.compile("[1-9][0-9]*lb").matcher(tempWeight).matches() ||
                                            Pattern.compile("[1-9][0-9]*lbs").matcher(tempWeight).matches()) {
                                        character.weight = tempWeight;
                                        break;
                                    } else {
                                        System.out.println("Invalid input.");
                                    }
                                }
                                break;
                            case 4:
                                System.out.print("Please enter your character's occupation >> ");
                                character.occupation = scanner.nextLine();
                                break;
                            case 5:
                                while (true) {
                                    System.out.print("Please enter your character's age (Min 15, Max 89) >> ");
                                    try {
                                        character.age = Integer.parseInt(scanner.nextLine());
                                        if (character.age < 15 || character.age > 89) {
                                            System.out.println("Invalid input.");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input.");
                                    }
                                }
                                break;
                            case 6:
                                while (true) {
                                    System.out.print("Please enter your character's sex (M/F) >> ");
                                    character.sex = scanner.nextLine().toLowerCase();
                                    if (character.sex.equals("m") || character.sex.equals("f")) {
                                        break;
                                    } else {
                                        System.out.println("Invalid input.");
                                    }
                                }
                                break;
                            case 7:
                                System.out.print("Please enter your character's residence >> ");
                                character.residence = scanner.nextLine();
                                break;
                            case 8:
                                System.out.print("Please enter your character's birthplace >> ");
                                character.birthplace = scanner.nextLine();
                                break;
                            case 9:
                                System.out.print("Please enter your character's nationality >> ");
                                character.birthplace = scanner.nextLine();
                                break;
                        }
                    } else {
                        break;
                    }
                }
                int[] STRs = new int[3];
                int[] CONs = new int[3];
                int[] SIZs = new int[3];
                int[] DEXs = new int[3];
                int[] APPs = new int[3];
                int[] INTs = new int[3];
                int[] POWs = new int[3];
                int[] EDUs = new int[3];
                int[] LUKs = new int[3];
                for (int i = 0; i < 3; i++) {
                    STRs[i] = Dice.roll(3, 6) * 5;
                    CONs[i] = Dice.roll(3, 6) * 5;
                    SIZs[i] = Dice.roll(2, 6, 6) * 5;
                    EDUs[i] = Dice.roll(3, 6) * 5;
                    APPs[i] = Dice.roll(3, 6) * 5;
                    DEXs[i] = Dice.roll(3, 6) * 5;
                    INTs[i] = Dice.roll(2, 6, 6) * 5;
                    POWs[i] = Dice.roll(3, 6) * 5;
                    LUKs[i] = Dice.roll(3, 6) * 5;
                }
                System.out.println("     1  2  3");
                System.out.printf("STR: %d%s%d%s%d%n", STRs[0], getSpace(STRs[0]), STRs[1], getSpace(STRs[1]), STRs[2]);
                System.out.printf("CON: %d%s%d%s%d%n", CONs[0], getSpace(CONs[0]), CONs[1], getSpace(CONs[1]), CONs[2]);
                System.out.printf("SIZ: %d%s%d%s%d%n", SIZs[0], getSpace(SIZs[0]), SIZs[1], getSpace(SIZs[1]), SIZs[2]);
                System.out.printf("DEX: %d%s%d%s%d%n", DEXs[0], getSpace(DEXs[0]), DEXs[1], getSpace(DEXs[1]), DEXs[2]);
                System.out.printf("APP: %d%s%d%s%d%n", APPs[0], getSpace(APPs[0]), APPs[1], getSpace(APPs[1]), APPs[2]);
                System.out.printf("INT: %d%s%d%s%d%n", INTs[0], getSpace(INTs[0]), INTs[1], getSpace(INTs[1]), INTs[2]);
                System.out.printf("POW: %d%s%d%s%d%n", POWs[0], getSpace(POWs[0]), POWs[1], getSpace(POWs[1]), POWs[2]);
                System.out.printf("EDU: %d%s%d%s%d%n", EDUs[0], getSpace(EDUs[0]), EDUs[1], getSpace(EDUs[1]), EDUs[2]);
                System.out.printf("LUK: %d%s%d%s%d%n", LUKs[0], getSpace(LUKs[0]), LUKs[1], getSpace(LUKs[1]), LUKs[2]);

                int statRow = -1;
                System.out.print("Please select a stat row >> ");
                while (true) {
                    try {
                        statRow = Integer.parseInt(scanner.nextLine());
                        if (statRow == 1 || statRow == 2 || statRow == 3) {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input.");
                    }
                    System.out.print("Please select valid a stat row >> ");
                }
                statRow--;
                character.setStats(
                        STRs[statRow],
                        CONs[statRow],
                        SIZs[statRow],
                        DEXs[statRow],
                        APPs[statRow],
                        INTs[statRow],
                        POWs[statRow],
                        EDUs[statRow],
                        LUKs[statRow]
                );
                character.save();
                break;
            case 2:
                // Load a character

                break;
            case 3:
                // Exit
                System.exit(0);
            case 1002:
                // Test
                break;
            default:
                // Invalid input
                System.out.println("Invalid input.");
                start(scanner);
                break;
        }
    }

    private static String getSpace(int stat) {
        String spaces = "";
        for (int i = 0; i < 3 - String.valueOf(stat).length(); i++) {
            spaces += " ";
        }
        return spaces;
    }
}