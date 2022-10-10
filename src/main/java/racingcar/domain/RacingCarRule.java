package racingcar.domain;

public class RacingCarRule {

    public static final int CAR_MOVE_CONDITION_MORE_THAN_NUMBER = 4;
    public static final int CAR_NAME_LENGTH = 5;
    public static final int CAR_RANDOM_MIN_NUMBER = 0;
    public static final int CAR_RANDOM_MAX_NUMBER = 9;
    public static final String ERROR = "[ERROR]";
    public static final String NAME_NULL_EXCEPTION = String.format("%s 자동차 이름을 입력하여 주세요.", ERROR);
    public static final String NAME_LENGTH_EXCEPTION = String.format("%s 자동차 이름은 1글자 이상, 5글자 이하로 작셩하여 주세요.", ERROR);
    public static final String RACING_CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_NUMBER_TO_TRY = "시도활 횟수는 몇회 인가요?";
    public static final String NUMBER_TO_TRY_EXCEPTION = "시도할 횟수는 숫자로만 작성하여 주세요.";
    public static final String GAME_FINISH = "최종 우승자 : ";
}
