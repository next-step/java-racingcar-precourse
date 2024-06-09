package main.java.racingcar.message;

public class ErrorMessage {

    private ErrorMessage() {
    }

    public static String INPUT_BLANK = "[ERROR] 빈 값을 입력 했습니다.";
    public static String INVALID_CAR_NAME = "[ERROR] 자동차 이름은 5자 이하여야 합니다.";

    public static String INVALID_NEGATIVE = "0보다 작은 값을 입력할 수 없습니다.";
}
