package view;

import util.SplitingCarName;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] inputCarNames(){
        String carNames = scanner.nextLine();
        return SplitingCarName.splitCarName(carNames);
    }

    public String inputTryCount(){
        return scanner.nextLine();
    }
}
