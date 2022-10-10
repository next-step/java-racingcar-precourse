package racingcar.referee.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputMovingNumber {

    private static final String SHOW_INPUT_MOVING_NUMBER_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RETRY_SHOW_INPUT = "숫자를 입력해 주세요";
    private static final String MOVING_NUMBER_SIZE_ERROR_MESSAGE = "[ERROR] 1이상의 숫자를 입력해주세요";

    public static int readMovingNumber() {
        System.out.println(SHOW_INPUT_MOVING_NUMBER_MESSAGE);
        try {
            int movingNumber = Integer.parseInt(Console.readLine());
            validateMovingNumberSize(movingNumber);
            return movingNumber;
        } catch (NumberFormatException e) {
            System.out.println(RETRY_SHOW_INPUT);
            System.out.println();
            return readMovingNumber();
        }
    }

    private static void validateMovingNumberSize(int movingNumber) {
        if (movingNumber < 1) {
            System.out.println(MOVING_NUMBER_SIZE_ERROR_MESSAGE);
            System.out.println();
            throw new IllegalArgumentException(MOVING_NUMBER_SIZE_ERROR_MESSAGE);
        }
    }
}
