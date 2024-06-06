package view;

import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);

    public static String[] scanCarNames() {
        String input = scanner.nextLine();
        return input.split(",");
    }

    public static String scanNumber() {
        return scanner.nextLine();
    }
}
