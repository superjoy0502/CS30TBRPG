package io.github.superjoy0502.cs30tbrpg;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.superjoy0502.cs30tbrpg.character.Character;
import io.github.superjoy0502.cs30tbrpg.character.PlayerCharacter;
import io.github.superjoy0502.cs30tbrpg.scenario.*;
import io.github.superjoy0502.cs30tbrpg.utilities.Dice;
import io.github.superjoy0502.cs30tbrpg.utilities.Save;
import io.github.superjoy0502.cs30tbrpg.utilities.SuccessLevel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private Scanner scanner;
    private UUID uuid;

    public Menu menu;
    public PlayerCharacter playerCharacter = null;
    public Scenario scenario = null;
    private String currentPos = "";

    public Game(Scanner scanner) {
        this.scanner = scanner;
        menu = new Menu(scanner, this);
    }

    public void start() {
        if (playerCharacter == null) {
            System.out.println("No character selected.");
            return;
        }
        if (scenario == null) {
            System.out.println("No scenario loaded.");
            return;
        }
        currentPos = idToPos(0);
        System.out.println();
        display(currentPos);
    }

    public void load(UUID uuid, Scenario scenario, PlayerCharacter character, String pos) {
        this.uuid = uuid;
        this.scenario = scenario;
        this.playerCharacter = character;
        currentPos = pos;
        System.out.println();
        display(currentPos);
    }

    public void display(String pos) {
        if (scenario == null) {
            System.out.println("No scenario loaded.");
            return;
        }
        // Save current game
        ArrayList<Save> saves = menu.getSaves();
        for (int i = 0; i < saves.size(); i++) {
            Save save = saves.get(i);
            if (save.getUuid().equals(uuid.toString())) {
                saves.remove(i);
            }
        }
        saves.add(new Save(uuid.toString(), new Date().toString(), scenario.getTitle(), playerCharacter.name, pos));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(saves);
        try (Writer writer = new FileWriter("resources/saves.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Press Enter to continue
        System.out.println("Press Enter to continue.");
        scanner.nextLine();
        int episodeId = getEpisodeId(pos);
        String type = getDialogueChoiceType(pos);
        int id = getDialogueChoiceId(pos);
        if (type.equals("dl")) {
            // Display dialogue
            displayDialogue(episodeId, id);
        } else if (type.equals("ch")) {
            // Display choice
            displayChoice(episodeId, id);
        }
    }

    private void displayDialogue(int episodeId, int dialogueId) {
        Episode episode = scenario.getEpisodes().get(episodeId);
        Dialogue dialogue = episode.getDialogues().get(dialogueId);
        dialogue.print();
        String roll = dialogue.getRoll();
        if (roll != null) {
            String[] rollParts = roll.split("/");
            String rollTarget = rollParts[0];
            String onSuccess = rollParts[1];
            String onFailure = rollParts[2];
            int rollResult = playerCharacter.roll(rollTarget).ordinal();
            if (rollResult >= SuccessLevel.SUCCESS.ordinal()) {
                if (onSuccess.matches(Dice.regex)) {
                    // Roll dice
                    int rollValue = Dice.roll(onSuccess);
                    playerCharacter.SAN -= rollValue;
                    System.out.println("SAN - " + rollValue + "(" + onSuccess + ")" + " > " + playerCharacter.SAN);
                } else {
                    currentPos = idToPos(onSuccess);
                    display(currentPos);
                    return;
                }
            } else {
                if (onFailure.matches(Dice.regex)) {
                    // Roll dice
                    int rollValue = Dice.roll(onFailure);
                    playerCharacter.SAN -= rollValue;
                    System.out.println("SAN - " + rollValue + "(" + onFailure + ")" + " > " + playerCharacter.SAN);
                } else {
                    currentPos = idToPos(onFailure);
                    display(currentPos);
                    return;
                }
            }
        }
        if (dialogue.getContinueTo() == null) {
            if (episode.getDialogues().indexOf(dialogue) == episode.getDialogues().size() - 1) {
                // End of episode
                currentPos = idToPos(episodeId + 1);
            } else {
                // Next dialogue
                currentPos = idToPos(episodeId, "dl", dialogueId + 1);
            }
        } else if (dialogue.getContinueTo().equals("end")) {
            System.out.println("The End.");
            System.exit(0);
        } else {
            currentPos = idToPos(episodeId, dialogue.getContinueTo());
        }
        display(currentPos);
    }

    private void displayChoice(int episodeId, int choiceId) {
        Episode episode = scenario.getEpisodes().get(episodeId);
        Choice choice = episode.getChoices().get(choiceId);
        choice.print();
        int choiceNum = getIntegerFromUser("Enter a number >> ", 0, choice.getPrompts().size());
        Consequence consequence;
        try {
            consequence = choice.getConsequences().get(choiceNum);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Consequence for the choice not found.");
        }
        consequence.print();
        String roll = consequence.getRoll();
        if (roll != null) {
            String[] rollParts = roll.split("/");
            String rollTarget = rollParts[0];
            String onSuccess = rollParts[1];
            String onFailure = rollParts[2];
            int rollResult = playerCharacter.roll(rollTarget).ordinal();
            if (rollResult >= SuccessLevel.SUCCESS.ordinal()) {
                if (onSuccess.matches(Dice.regex)) {
                    // Roll dice
                    int rollValue = Dice.roll(onSuccess);
                    System.out.println("You rolled " + rollValue + ".");
                } else {
                    currentPos = idToPos(onSuccess);
                    display(currentPos);
                    return;
                }
            } else {
                if (onFailure.matches(Dice.regex)) {
                    // Roll dice
                    int rollValue = Dice.roll(onFailure);
                    System.out.println("You rolled " + rollValue + ".");
                } else {
                    currentPos = idToPos(onFailure);
                    display(currentPos);
                    return;
                }
            }
        }
        if (consequence.getContinueTo() == null) {
            throw new NullPointerException("Consequence must have a continueTo.");
        } else if (consequence.getContinueTo().equals("lost")) {
            // TODO Lost function
            System.out.println("You lost.");
            System.exit(0);
        } else {
            currentPos = idToPos(consequence.getContinueTo());
            display(currentPos);
        }
    }

    public int getIntegerFromUser(String prompt, int min, int max) {
        int input = getIntegerFromUser(prompt);
        while (input < min || input > max) {
            System.out.println("Invalid input.");
            input = getIntegerFromUser(prompt);
        }
        return input;
    }

    public int getIntegerFromUser(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input.");
            System.out.print(prompt);
            scanner.next();
        }
        return scanner.nextInt();
    }

    private String idToPos(String id) {
        // Check if id is in the form "ep#" else if "dl#" else if "ch#"
        if (id.matches("^ep\\d+$")) {
            return id + "dl0";
        } else if (id.matches("^dl\\d+$") || id.matches("^ch\\d+$")) {
            return "ep" + getEpisodeId() + id;
        } else {
            return id;
        }
    }
    private String idToPos(int episodeId) {
        return "ep" + episodeId + "dl0";
    }

    private String idToPos(int episodeId, String id) {
        if (id.startsWith("ep")) {
            return id;
        }
        return "ep" + episodeId + id;
    }

    private String idToPos(int episodeId, String type, int id) {
        return "ep" + episodeId + type + id;
    }

    public int getEpisodeId() {
        return getEpisodeId(currentPos);
    }

    public int getEpisodeId(String pos) {
        Pattern pattern = Pattern.compile("^ep(\\d+)(dl|ch)(\\d+)$");
        Matcher matcher = pattern.matcher(pos);
        if (matcher.matches()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            throw new IllegalArgumentException("Invalid position.");
        }
    }

    public String getDialogueChoiceType() {
        return getDialogueChoiceType(currentPos);
    }

    public String getDialogueChoiceType(String pos) {
        Pattern pattern = Pattern.compile("^ep(\\d+)(dl|ch)(\\d+)$");
        Matcher matcher = pattern.matcher(pos);
        if (matcher.matches()) {
            return matcher.group(2);
        } else {
            throw new IllegalArgumentException("Invalid position.");
        }
    }

    public int getDialogueChoiceId() {
        return getDialogueChoiceId(currentPos);
    }

    public int getDialogueChoiceId(String pos) {
        Pattern pattern = Pattern.compile("^ep(\\d+)(dl|ch)(\\d+)$");
        Matcher matcher = pattern.matcher(pos);
        if (matcher.matches()) {
            return Integer.parseInt(matcher.group(3));
        } else {
            throw new IllegalArgumentException("Invalid position.");
        }
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
