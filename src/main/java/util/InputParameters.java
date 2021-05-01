package util;

import java.util.Scanner;

public class InputParameters {
    private final Scanner scanner = new Scanner(System.in);

    public String inputString(String message) {
        System.out.println(message);
        return scanner.next();
    }
}
