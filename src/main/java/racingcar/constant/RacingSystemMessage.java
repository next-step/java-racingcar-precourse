package racingcar.constant;

public enum RacingSystemMessage {
    INPUT_PLAY_COUNT_MESSAGE("시도할 회수는 몇회인가요?")
    ,INPUT_RACING_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분")
    ,OUTPUT_VICTORY_CAR("최종 우승자 : ")
    ,OUTPUT_RESULT_INFO("실행 결과");

    private final String message;
    RacingSystemMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
