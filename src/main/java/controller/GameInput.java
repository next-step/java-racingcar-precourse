package controller;

import java.util.Scanner;

public class GameInput {

    private Scanner scanner = new Scanner(System.in);
    public String initialCarNames(){
        String names = scanner.nextLine();
        return names;
    }
    public String raceAttemps(){
        return scanner.nextLine();
    }
}
