package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private String[] carNames;
    private int iteration;

    public void inputName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.carNames = scanner.nextLine().split("\\s*,\\s*");
    }

    public String[] getCarNames() {
        return this.carNames;
    }

    public int getIteration() {
        return this.iteration;
    }

}
