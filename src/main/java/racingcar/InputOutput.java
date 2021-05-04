package racingcar;

import java.util.Scanner;

public class InputOutput {
    private static Scanner scan = new Scanner(System.in);

    public static String input() {
        String input = scan.nextLine();

        return input;
    }

    public static void print(String output) {
        System.out.println(output);
    }

    public static void print() {
        System.out.println();
    }
}
