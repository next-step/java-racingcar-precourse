package racingcar.message;

public class ErrorMessage {
    public static String ERR_PRE_MESSAGE = "[ERROR] ";
    public static String ERR_INPUT_THE_CAR_NAME = "자동차의 이름을 입력해주세요.";
    public static String ERR_VALID_NAME_ONE_TO_FIVE = "자동차의 이름은 1-5자 이어야합니다.";
    public static String ERR_VALID_RACE_COUNT = "시도 횟수는 숫자여야 합니다.";

    public static String getMessage(String errorMessage){
        return ERR_PRE_MESSAGE + errorMessage;
    }

    public static String getMessageValidNameOneToFive(){
        return ERR_PRE_MESSAGE + ERR_VALID_NAME_ONE_TO_FIVE;
    }

}