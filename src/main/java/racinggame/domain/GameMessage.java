package racinggame.domain;

/**
 * 자동차 게임에서 사용되는 메세지를 정의
 * @author Lee SeongHyeok <dltjdgur327@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public enum GameMessage {

    /** 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) */
    INPUT_RACING_CAR_NAME_WITH_COMMA("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),

    /** 시도할 회수는 몇회인가요? */
    INPUT_TRY_COUNT("시도할 회수는 몇회인가요?"),

    /** 실행 결과 */
    OUTPUT_GAME_RESULT("실행 결과"),
    ;

    private String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
