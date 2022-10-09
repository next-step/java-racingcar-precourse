package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
        throw new IllegalStateException("입력을 위한 유틸리티 클래스입니다.");
    }

    private static final String SEPARATOR = ",";

    public static String[] typeCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        return carNames.split(SEPARATOR);
    }

    public static int typeNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String attempt = Console.readLine();
        validateNumber(attempt);
        return Integer.parseInt(attempt);
    }

    private static void validateNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }
}
