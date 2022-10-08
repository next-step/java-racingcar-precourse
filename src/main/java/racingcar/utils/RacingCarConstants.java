package racingcar.utils;

public class RacingCarConstants {
    // Input CarName
    public static final int CAR_NAME_MAX_LENGTH = 5; // 자동차 이름 최대 길이
    public static final int MIN_PARTICIPANT_CARS = 2; // 참가하는 자동차 최소 인원
    public static final String CAR_NAME_SPLIT_CHARACTER = ","; // 자동차 이름 구분 문자열
    // Input try count
    public static final int MAX_INPUT_MOVE_COUNT = 4; // 입력받을 수 있는 시도할 횟수에 대한 최대 문자열 길이
    public static final int MIN_INPUT_MOVE_COUNT = 1; // 입력받은 시도할 횟수 최소 값

    // Random Generator
    public static final int MIN_RANDOM_NUM = 0; // 난수 최소 값
    public static final int MAX_RANDOM_NUM = 9; // 난수 최대 값

    // Move Strategy
    public static final int MIN_POWER = 4; // 전진 or 정지 정하는 기준
    public static final String DISTANCE_PRINT_CHARACTER = "-";

    // Exception
    public static final String COMMON_ERROR_MESSAGE = "[ERROR]";
    public static final String MSG_NUMBER_FORMAT_EXCEPTION = "숫자만 입력할 수 있습니다.";
    public static final String MSG_MOVE_COUNT_LENGTH_EXCEED_EXCEPTION = "입력할 수 있는 숫자는 최대 4자리입니다.";
    public static final String MSG_MOVE_MIN_VALUE_EXCEPTION = "시도할 횟수는 최소 1이상입니다.";
    public static final String MSG_CAR_NAME_LENGTH_EXCEPTION = "자동차의 이름은 5글자 이하로 입력해야 합니다.";
    public static final String MSG_CAR_NAME_DUPLICATE_EXCEPTION = "게임에 참가하는 자동차의 이름은 중복 허용이 안됩니다.";
    public static final String MSG_GAME_PARTICIPANT_ILLEGAR_EXCEPTION = "게임에 참가하는 자동차는 2대 이상이어야 합니다.";


}
