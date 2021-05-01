package com.bistros.racing.game;

import java.util.Scanner;

public interface CommandLineInterface {
    default String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
