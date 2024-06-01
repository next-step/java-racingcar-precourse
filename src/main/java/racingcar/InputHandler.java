package racingcar;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        validateCarNames(input);
        return input;
    }

    private static void validateCarNames(String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
        }

        for (String name : carNames.split(",")) {
            validateCarName(name.trim());
        }
    }

    private static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public static int inputAttempts() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = scanner.nextLine();
        return parseAttempts(input);
    }

    private static int parseAttempts(String input) {
        try {
            return validateAttempts(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }
    }

    private static int validateAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 회수는 1회 이상이어야 합니다.");
        }
        return attempts;
    }
}