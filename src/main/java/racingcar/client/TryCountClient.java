package racingcar.client;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.TryCount;
import racingcar.utils.CompareUtils;

public class TryCountClient {
    public static final String ERROR_MESSAGE_TRY_COUNT_ONLY_POSITIVE_NUMBER = "시도 회수는 숫자만 입력 가능합니다.";
    private static final String INPUT_MESSAGE_FOR_TRY_COUNT = "시도할 회수는 몇회인가요?";

    private TryCountClient() {
    }

    public static TryCount inputTryCountUntilSuccess() {
        printInputMessageForTryCount();

        while (true) {
            String inputString = Console.readLine();
            try {
                validateIsPositiveInteger(inputString);
                return TryCount.from(
                        Integer.parseInt(inputString)
                );
            } catch (Exception exception) {
                ErrorMessageClient.printErrorMessage(exception.getMessage());
            }
        }
    }

    private static void validateIsPositiveInteger(String inputString) {
        if (!CompareUtils.isPositiveInteger(inputString)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TRY_COUNT_ONLY_POSITIVE_NUMBER);
        }
    }

    private static void printInputMessageForTryCount() {
        System.out.println(INPUT_MESSAGE_FOR_TRY_COUNT);
    }
}
