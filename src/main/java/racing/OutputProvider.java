package racing;

public class OutputProvider {
    public static final String RESULT_HEADER = "실행 결과";
    public static final String MESSAGE_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String MESSAGE_INPUT_ROUND_NUMBER = "시도할 회수는 몇회인가요?";
    public static final String RESULT_FOOTER_POSTFIX = "가 최종 우승했습니다.";
    public static final String NEW_LINE = "\n";

    private GameState gameState;
    private Output result;

    public OutputProvider() {
        this.gameState = GameState.WAIT_FOR_INPUT_NAMES;
        result = new Output(RESULT_HEADER);
    }

    public Output parseCarSet(CarSet carset) {
        StringBuilder buffer = new StringBuilder();
        for (Car car : carset) {
            buffer.append(car.toString()).append(NEW_LINE);
        }
        return new Output(buffer.toString());
    }

    public Output getOutput() {
        if (gameState.isWaitForInputName())
            return new Output(MESSAGE_INPUT_CAR_NAME);
        else if (gameState.isWaitForInputRound())
            return new Output(MESSAGE_INPUT_ROUND_NUMBER);
        else if (gameState.isReadyForResult())
            return result;

        throw new IllegalStateException("no output provide on " + gameState + " state");
    }

    public void setState(GameState state) {
        gameState = state;
    }

    public void addResult(CarSet carset) {
        Output step = parseCarSet(carset);
        result = result.concatln(step);
    }

    public void addCompleteResult(CarSet winners) {
        Output lastLine = new Output(winners.getNames()).concat(RESULT_FOOTER_POSTFIX);
        result = result.concatln(lastLine);
    }
}
