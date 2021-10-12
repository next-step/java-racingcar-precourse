package racinggame.domain;

/**
 * 자동차 게임에서 사용되는 설정값을 정의
 * @author Lee SeongHyeok <dltjdgur327@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public enum GameConfig {

    /** 자동차 이동 - 전진 */
    MOVING_FORWARD(4),

    /** 자동차 이동 - 정지 */
    STOP(3),

    /** 랜덤값 범위의 시작값, 리턴 범위내에 포함 */
    START_INCLUSIVE(0),

    /** 랜덤값 범위의 끝값, 리턴 범위내에 포함 */
    END_INCLUSIVE(9),

    /** 자동차 이름의 최소 길이 */
    RACING_CAR_NAME_MIN_LENGTH(1),

    /** 자동차 이름의 최대 길이 */
    RACING_CAR_NAME_MAX_LENGTH(5),

    /** 최소 시도 횟수 */
    TRY_COUNT_MIN_VALUE(1),

    /** 자동차 이름 SPLIT 구분자 */
    SPLIT_REGEX(","),
    ;

    private int value;
    private String splitRegex;

    GameConfig(int value) {
        this.value = value;
    }

    GameConfig(String splitRegex) {
        this.splitRegex = splitRegex;
    }

    public int getValue() {
        return value;
    }

    public String getSplitRegex() {
        return splitRegex;
    }
}
