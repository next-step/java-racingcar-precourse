package racingcar.enums;

public enum GameMsgEnum {
    NAME_MSG("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,), 기준으로 구분)"),
    COUNT_MSG("시도할 회수는 몇회인가요?"),
    RESULT_MSG("각 차수별 실행결과"),
    FINAL_BEFORE_NAME_MSG("최종 우승자: ");

    private String value;

    private GameMsgEnum(String value){
        this.value = value;
    }

    public String value(){
        return value;
    }
}
