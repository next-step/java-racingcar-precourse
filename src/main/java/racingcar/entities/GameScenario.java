package racingcar.entities;

public enum GameScenario {
    ASK_RACING_CARS_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_GAME_TIMES("시도할 회수는 몇회인가요?"),
    ANNOUNCE_WINNER("최종 우승자 : "),
    ASK_GAME_STARTS_WITH_ONE_CAR("구분자(쉼표(,)를 입력하지 않으셨습니다. 입력한 이름의 자동차 한 대로 게임을 진행하려면 1, 다시 입력하려면 2를 입력해주세요"),
    ;
    private final String gamePhrases;


    GameScenario(String gamePhrases) {
        this.gamePhrases = gamePhrases;
    }

    public String getGamePhrases() {
        return gamePhrases;
    }
}
