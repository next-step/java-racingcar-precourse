package controller;

import java.util.List;
import java.util.Scanner;
import view.InputView;

public class RaceInputController {
    private final Scanner sc;

    public RaceInputController() {
        sc = new Scanner(System.in);
    }

    public List<String> getUserInputForCarNames() {
        while (true) {
            try {
                InputView.printCarNameInput();
                String input = sc.nextLine();
                return InputValidator.validateCarName(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getUserInputForRaceCount() {
        while (true) {
            try {
                sc.nextLine();
                InputView.printCountInput();
                final String input = sc.nextLine();
                return InputValidator.validateRaceCount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
