package racingcar.model.cars.factory;

import racingcar.model.cars.Car;

public class CarFactory {
    public static Car create(Title title) {
        return new Car(
                title,
                CarFactory.createEngine(),
                CarFactory.createMoveHistory()
        );
    }

    private static Engine createEngine() {
        return new Engine();
    }

    private static MoveHistory createMoveHistory() {
        return new MoveHistory();
    }
}
