package view;

import java.util.Scanner;

public class InputView implements AutoCloseable {

    private static final Scanner scanner = new Scanner(System.in);

    public String enterCarNames() {
        return promptUser("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public String enterTryCount() {
        return promptUser("시도할 회수는 몇회인가요?");
    }

    private String promptUser(String message) {
        System.out.println(message);
        return scanner.nextLine().trim();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
