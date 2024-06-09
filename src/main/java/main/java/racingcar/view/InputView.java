package main.java.racingcar.view;


import main.java.racingcar.message.ErrorMessage;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static String inputString(String message) {
        System.out.println(message);
        String inputValue = scanner.nextLine();
        validateBlank(inputValue);
        return inputValue;
    }

    public static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK);
        }
    }
}
