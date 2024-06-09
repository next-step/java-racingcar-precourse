package view;

import java.util.List;
import java.util.Scanner;

public class OutputView {

    private static final String ERROR_LABEL = "[ERROR]";
    private static final String OUTPUT_MESSAGE = "실행 결과";
    private Scanner scanner;

    public OutputView() {
        this.scanner = new Scanner(System.in);
    }

    public void printOutput() {
        System.out.println();
        System.out.println(OUTPUT_MESSAGE);
    }

    public void printRacingCar(String name, int position) {
        System.out.println(name + " : " + "-".repeat(position));
    }

    public void printErrorMessage(String message) {
        System.err.println(ERROR_LABEL + " " + message);
    }
}
