package io.github.superjoy0502.cs30tbrpg;

import java.util.Scanner;

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
        Game game = new Game(scanner);
        game.menu.open();
    }
}