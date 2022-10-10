package racingcar.model.value;

/**
 * 에러 메시지 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class ErrorMsg {

    public static final String BASE = "[ERROR] ";
    public static final String EMPTY_INPUT = "입력이 비었습니다. 다시 입력해주세요";
    public static final String ONE_CAR_NAME = "경기를 위해선 차가 한대 이상 등록되어야합니다.";
    public static final String DUPLICATE_NAME = "차 이름은 중복될 수 없습니다.";
    public static final String WRONG_TYPE = "시도횟수는 1이상 숫자여야합니다.";
    public static final String WHITE_SPACE = "자동차 이름은 공백이 제거되어야 합니다.";
    public static final String CAR_NAME_LENGTH_NO_MATCH = "차 이름은 1글자 이상 5글자 이하여야 합니다.";
    public static final String CANNOT_START_RACE_NO_READY = "경기가 준비되어야 시작할 수 있습니다.";
    public static final String CANNOT_ANNOUNCE_FINAL_WINNER = "경기가 안끝나서 최종 우승자를 발표할 수 없습니다.";

    public static final String ZERO_WINNER = "경기의 승자가 없을 수 없습니다.";
}
