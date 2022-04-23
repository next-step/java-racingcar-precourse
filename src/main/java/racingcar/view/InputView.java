package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.PositiveNumber;
import racingcar.racing.Racing;

import java.util.function.Supplier;

public class InputView {
    private static final String PREFIX_ERROR_MESSAGE = "[ERROR]";

    private InputView() {}

    public static Racing enterCarNames() {
        return untilEnterValidValue(() -> {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

            return new Racing(Console.readLine());
        });
    }

    public static void enterPlayCount(Racing racing) {
        untilEnterValidValue(() -> {
            System.out.println("시도할 회수는 몇회인가요?");
            racing.play(new PositiveNumber(Console.readLine()));

            return null;
        });
    }

    private static <T> T untilEnterValidValue(Supplier<T> action) {
        boolean isSuccessInput = false;
        T result = null;

        while (!isSuccessInput) {
            try {
                result = action.get();
                isSuccessInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(PREFIX_ERROR_MESSAGE + " " + e.getMessage());
            }
        }

        return result;
    }
}
