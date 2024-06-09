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

    public static int inputInteger(String message) {
        System.out.println(message);
        String inputValue = scanner.nextLine();
        validateBlank(inputValue);
        validateInteger(inputValue);
        return Integer.parseInt(inputValue);
    }

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_INTEGER);
        }
    }
}
