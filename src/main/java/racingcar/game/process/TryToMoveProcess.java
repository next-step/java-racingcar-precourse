package racingcar.game.process;

import static racingcar.constants.Message.TRY_TO_MOVE_HEAD_MESSAGE;
import static racingcar.constants.Message.TRY_TO_MOVE_RESULT_PATTERN;

import racingcar.game.dto.GameStatus;
import racingcar.io.Output;
import racingcar.model.Car;
import racingcar.model.Cars;

public class TryToMoveProcess implements GameProcess {

    private static final String LINE = "-";

    @Override
    public GameStatus execute(final GameStatus gameStatus) {
        Output.line();
        Output.println(TRY_TO_MOVE_HEAD_MESSAGE);

        for (int i = 0; i < gameStatus.getTryCount(); i++) {
            gameStatus.getCars().move();
            outputCar(gameStatus);
        }

        return new GameStatus(new WinnersProcess(), gameStatus.getCars(), gameStatus.getTryCount());
    }

    private void outputCar(GameStatus gameStatus) {
        Output.line();
        Cars cars = gameStatus.getCars();

        for (Car car : cars.getResults()) {
            String line = distanceToLine(car.getDistance());
            Output.println(String.format(TRY_TO_MOVE_RESULT_PATTERN, car.getName(), line));
        }
    }

    private String distanceToLine(final int distance) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < distance; i++) {
            sb.append(LINE);
        }

        return sb.toString();
    }
}
