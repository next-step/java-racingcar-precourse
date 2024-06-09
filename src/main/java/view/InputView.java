package view;

import util.SplitingCarName;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] inputCarNames(){
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = scanner.nextLine();
        return SplitingCarName.splitCarName(carNames);
    }
}
