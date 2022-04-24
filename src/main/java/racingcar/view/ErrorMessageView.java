package racingcar.view;

public class ErrorMessageView {
    private static final String BLANK_CAR_NAME = "[ERROR] 차량명이 공백입니다. 차량명을 입력해 주세요";
    private static final String MAX_CAR_NAME = "[ERROR] 차량명이 공백입니다. 차량명을 입력해 주세요";
    private static final String DUPLICATE_CAR_NAME = "[ERROR] 차량명이 공백입니다. 차량명을 입력해 주세요";
    private static final String PLEASE_INPUT_NUMBER = "[ERROR] 시도 할 횟수는 숫자여야 합니다.";

    public static void throwErrorBlankCarName() {
        throw new IllegalArgumentException(BLANK_CAR_NAME);
    }

    public static void throwErrorMaxCarName() {
        throw new IllegalArgumentException(MAX_CAR_NAME);
    }

    public static void throwErrorDuplicateCarName() {
        throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
    }

    public static void throwErrorPleaseInputNumber() {
        throw new IllegalArgumentException(PLEASE_INPUT_NUMBER);
    }
}
