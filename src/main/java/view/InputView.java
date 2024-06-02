package view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String obtainCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scanner.nextLine();
    }

    public String obtainAttempt() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextLine();
    }
}
