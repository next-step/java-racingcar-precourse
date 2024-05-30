package util;

import java.util.Scanner;

public class IOHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public String getStringInput() {
        return scanner.nextLine();
    }

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void printError(String message) {
        System.err.println(message);
    }
}
