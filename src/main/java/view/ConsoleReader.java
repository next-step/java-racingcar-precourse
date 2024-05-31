package view;

import java.util.Scanner;

public class ConsoleReader {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String enterMessage() {
        return SCANNER.nextLine();
    }
}