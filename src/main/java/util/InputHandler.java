package util;

import java.util.Scanner;

public class InputHandler {

    private static Scanner scanner;

    private InputHandler() {}

    public static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static void close() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    public static String getInput() {
        return getInstance().nextLine();
    }
}