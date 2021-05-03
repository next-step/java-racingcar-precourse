package racingcar.view;

import java.util.Scanner;

public class UserInputView {
    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_MOVE_COUNT = "시도할 회수는 몇회인가요?";
    private final Scanner scanner;

    public UserInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String requestCarNames() {
        System.out.println(REQUEST_CAR_NAMES_MESSAGE);
        return scanner.nextLine();
    }

    public String requestMoveCount() {
        System.out.println(REQUEST_MOVE_COUNT);
        return scanner.nextLine();
    }
}