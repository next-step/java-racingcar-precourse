package racingcar.message;

public class RacingCarMessage implements RacingCarMessageAware {

    private static final String NAMES_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_TEXT = "시도할 회수는 몇회인가요?";
    private static final String WINNER_TEXT = "최종 우승자 : ";

    public String getNames() {
        return NAMES_TEXT;
    }

    public String getTry() {
        return TRY_TEXT;
    }

    public String getWinner() {
        return WINNER_TEXT;
    }

    @Override
    public RacingCarMessage getMessage() {
        return this;
    }
}
