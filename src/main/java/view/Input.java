package view;

import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputCarNames() {
        String input = scanner.nextLine();
        return input.split(",");
    }

    public static String inputNumber() {
        return scanner.nextLine();
    }
}
