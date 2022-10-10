package racingcar.domain;

public class ErrorMessage {
    public static String CAR_NAME_SIZE = "자동차의 이름은 5자 이하만 가능합니다.";
    public static String MOVE_ONLY_FORWARD = "경주게임에서는 후진할 수 없습니다.";
    public static String CARS_SIZE = "자동차는 최소 2대가 필요합니다.";
    public static String CARS_NAME_SPLITTER = "자동차들의 이름은 쉼표(%s)로 구분되어야 합니다.";
    public static String ROUND_ONLY_NUMBER = "시도할 횟수는 숫자만 입력 가능합니다.";
    public static String ROUND_NUMBER_OVER_ONE = "시도할 횟수는 1번 이상이어야 합니다.";
    public static String DUPLICATE_CAR_NAME = "같은 자동차 이름은 입력할 수 없습니다.";
}
