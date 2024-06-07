package view;

import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);

    public String[] scanCarNames() {
        String input = scanner.nextLine();
        return input.split(",");
    }

    public String scanNumber() {
        return scanner.nextLine();
    }
}
