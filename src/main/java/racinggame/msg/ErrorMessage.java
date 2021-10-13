package racinggame.msg;

public class ErrorMessage {
    public static final String CAR_NAME_CAN_NOT_BE_NULL = "[ERROR] 자동차 이름을 입력해주세요.";
    public static final String NUMBER_OF_CAR_NAMES_CAN_BE_POSITIVE = "[ERROR] 자동차 이름 개수를 1개 이상 입력해주세요.";
    public static final String CAR_NAME_LENGTH_CAN_BE_IN_VALID_RANGE = "[ERROR] 자동차 이름의 길이는 1자 이상 5자 미만으로 입력해주세요.";
    public static final String CAR_NAME_CAN_NOT_BE_IN_BLANK = "[ERROR] 자동차 이름에 빈칸 없이 입력해주세요.";
    public static final String RACE_NUM_CAN_NOT_BE_NULL = "[ERROR] 이동 횟수를 입력해주세요.";
    public static final String RACE_NUM_LENGTH_CAN_BE_IN_VALID_RANGE = "[ERROR] 이동 횟수 입력 문자의 길이는 1자 이상으로 입력해주세요.";
    public static final String RACE_NUM_CAN_BE_INTEGER = "[ERROR] 이동 횟수는 0이상 2^31미만으로 입력해주세요.";
    public static final String RACE_NUM_CAN_BE_POSITIVE = "[ERROR] 이동 횟수는 0이상으로 입력해주세요.";
}
