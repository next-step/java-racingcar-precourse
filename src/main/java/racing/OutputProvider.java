package racing;

import java.util.ArrayList;
import java.util.List;

public class OutputProvider {
    private GameState gameState;
    private Output result;

    public OutputProvider() {
        this.gameState = GameState.WAIT_FOR_INPUT_NAMES;
        result = new Output("실행 결과");
    }

    public Output parseCarSet(CarSet carset) {
        StringBuilder buffer = new StringBuilder();
        for (Car car : carset) {
            buffer.append(car.toString() + "\n");
        }
        return new Output(buffer.toString());
    }

    public Output getOutput() {
        if (gameState == GameState.WAIT_FOR_INPUT_NAMES)
            return new Output("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        if (gameState == GameState.WAIT_FOR_INPUT_ROUND)
            return new Output("시도할 회수는 몇회인가요?");
        if (gameState == GameState.READY_FOR_RESULT)
            return result;

        throw new IllegalStateException("no ouput provide on " + gameState + " state");
    }

    public void setState(GameState state) {
        gameState = state;
    }

    public void addResult(CarSet carset) {
        Output step = parseCarSet(carset);
        result = result.concatln(step);
    }

    public void addCompleteResult(List<Car> winners) {
        List<String> names = new ArrayList<>();
        for (Car winner : winners) {
            names.add(winner.getName());
        }

        Output lastLine = new Output(names).concat(new Output("가 최종 우승했습니다."));
        result = result.concatln(lastLine);
    }
}
