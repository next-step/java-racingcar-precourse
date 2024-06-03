package view;

import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    public String getName() {
        return sc.nextLine();
    }

    public String getTryCount() {
        return sc.nextLine();
    }

}
