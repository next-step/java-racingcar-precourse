package racingcar.message;

public class ExceptionMessage {
    public static final String RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE = "[ERROR] 자동차 이름의 길이는 5자리를 초과해서는 안됩니다.";
    public static final String CONTAIN_SPECIAL_CHARACTER_EXCEPTION_MESSAGE = "[ERROR] 레이싱카 이름에 특수문자가 포함되서는 안됩니다(공백문자 포함).";
    public static final String RACING_CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE = "[ERROR] 레이싱카 이름은 중복되서는 안됩니다.";
    public static final String RACING_CAR_MAX_SIZE_EXCEPTION_MESSAGE = "[ERROR] 최대 허용 가능한 레이싱카 수를 초과하였습니다.";

    public static final String NOT_CONTAIN_ONLY_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 라운드수는 숫자외의 문자가 포함되서는 안됩니다.";
    public static final String MAX_ROUND_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 최대 입력 가능한 라운드 수는 1000라운드입니다.";
    public static final String MIN_ROUND_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 최소 입력 가능한 라운드 수는 1라운드입니다.";
}
