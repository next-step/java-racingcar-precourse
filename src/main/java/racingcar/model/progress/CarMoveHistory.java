package racingcar.model.progress;

import racingcar.model.cars.Car;
import racingcar.model.cars.factory.MoveHistory;
import racingcar.model.cars.factory.Title;

public class CarMoveHistory {
    private final Title title;
    private final MoveHistory moveHistory;

    private CarMoveHistory(Title title, MoveHistory moveHistory) {
        this.title = title;
        this.moveHistory = moveHistory;
    }

    public static CarMoveHistory of(Car car) {
        return new CarMoveHistory(car.getTitle(), car.getMoveHistory());
    }

    public Title getTitle() {
        return title;
    }

    public MoveHistory getMoveHistory() {
        return moveHistory;
    }
}
