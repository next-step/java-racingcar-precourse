package racingcar.game;

import racingcar.domain.Cars;
import racingcar.domain.MoveCount;
import racingcar.view.output.OutputView;

public class Race {
    private final Cars cars;
    private final MoveCount moveCount;

    public Race(Cars cars, MoveCount moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public void start() {
        while (moveCount.isMovableCount()) {
            moveCount.decrease();
            cars.move();
            OutputView.printRaceStatus(cars);
        }
    }
}
