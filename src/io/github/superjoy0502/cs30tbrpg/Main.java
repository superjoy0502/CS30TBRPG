package io.github.superjoy0502.cs30tbrpg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello Investigator.");
        System.out.println("Welcome to the Call of Cthulhu 7th Edition Text-Based RPG.");
        System.out.println("Let's get started.");
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
                character.name = (scanner.nextLine());
                System.out.print("Please enter your character's height >> ");
                character.height = (Float.parseFloat(scanner.nextLine()));
                System.out.print("Please enter your character's weight >> ");
                character.weight = (Float.parseFloat(scanner.nextLine()));
                System.out.print("Please enter your character's occupation >> ");
                character.occupation = (scanner.nextLine());
                System.out.print("Please enter your character's pronouns (ex. he/him/his) >> ");
                character.pronouns = (scanner.nextLine());
                System.out.print("Please enter your character's residence >> ");
                character.residence = (scanner.nextLine());
                System.out.print("Please enter your character's birthplace >> ");
                character.birthplace = (scanner.nextLine());
                System.out.print("Please enter your character's age >> ");
                character.age = (Integer.parseInt(scanner.nextLine()));
                System.out.print("Please enter your character's nationality >> ");
                character.nationality = scanner.nextLine();

                System.out.println("Do you confirm the following information?");
                System.out.println("1. Name: " + character.name);
                System.out.println("2. Height: " + character.height);
                System.out.println("3. Weight: " + character.weight);
                System.out.println("4. Occupation: " + character.occupation);
                System.out.println("5. Pronouns: " + character.pronouns);
                System.out.println("6. Residence: " + character.residence);
                System.out.println("7. Birthplace: " + character.birthplace);
                System.out.println("8. Age: " + character.age);
                System.out.println("9. Nationality: " + character.nationality);
                System.out.println("0. Yes");
                System.out.print("Please enter a number >> ");
                int confirm;
                try {
                    confirm = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                    start(scanner);
                    return;
                }
                switch (confirm) {
                    case 0:
                        // Yes
                        System.out.println("Character created.");
                        for (int rolls = 3; rolls < 0; rolls--) {
                            character.rollStats();
                            System.out.println("Do you like the following stats? (y/n) (" + rolls + " rolls left)");
                            System.out.println("STR: " + character.strength);
                            System.out.println("CON: " + character.constitution);
                            System.out.println("SIZ: " + character.size);
                            System.out.println("DEX: " + character.dexterity);
                            System.out.println("APP: " + character.appearance);
                            System.out.println("INT: " + character.intelligence);
                            System.out.println("POW: " + character.power);
                            System.out.println("EDU: " + character.education);
                            System.out.print("Please enter a letter >> ");
                            String like;
                            try {
                                like = scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println("Invalid input.");
                                start(scanner);
                                return;
                            }
                            if (like.equalsIgnoreCase("y")) {
                                rolls = 0;
                            } else if (like.equalsIgnoreCase("n")) {
                                if (rolls == 0) {
                                    System.out.println("You have no more rolls left.");
                                    start(scanner);
                                    return;
                                }
                            } else {
                                System.out.println("Invalid input.");
                                start(scanner);
                                return;
                            }
                        }
                        break;
                }
                System.out.println("Character created.");
                break;
            case 2:
                // Load a character
                break;
            case 3:
                // Exit
                System.exit(0);
            default:
                // Invalid input
                System.out.println("Invalid input.");
                start(scanner);
                break;
        }
    }
}