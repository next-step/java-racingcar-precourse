package racingcar.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String requestCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return getUserInput();
    }

    public String requestTrialNumberMessage() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return getUserInput();
    }

    private String getUserInput() {
        return scanner.nextLine();
    }
}
