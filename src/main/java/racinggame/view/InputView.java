package racinggame.view;

import nextstep.utils.Console;
import racinggame.model.enums.Error;

public class InputView {

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return input();
    }

    public static int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = input();
        return Integer.parseInt(input);
    }

    private static String input() {
        String input = Console.readLine();
        validateNull(input);
        return input;
    }

    private static void validateNull(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(Error.INPUT_MUST_NOT_BE_NULL.message());
        }
    }
}
