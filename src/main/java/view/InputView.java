package view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public void print(String str) {
        System.out.println(str);
    }

    public String question(String q) {
        this.print(q);
        return this.scanner.nextLine();
    }
}
