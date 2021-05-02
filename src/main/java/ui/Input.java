package ui;

import constant.ExceptionMessage;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String requestString() {
        return scanner.nextLine();
    }

    public static int requestInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_TYPE_MISMATCHING_EXCEPTION_INT);
        }
    }
}
