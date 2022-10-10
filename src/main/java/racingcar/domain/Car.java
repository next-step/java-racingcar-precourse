package racingcar.domain;

import racingcar.common.NaturalNumber;
import racingcar.common.UserString;
import racingcar.util.AccelGenerator;

public class Car {

    private final Engine engine;
    private final CarName carName;
    private NaturalNumber carPosition;

    private Car(Engine engine, CarName carName) {
        this.engine = engine;
        this.carName = carName;
        this.carPosition = NaturalNumber.of(0);
    }

    public static Car of(UserString carName) {
        return new Car(new Engine(), new CarName(carName));
    }

    public void drive() {
        AccelValue value = AccelGenerator.generate();
        Move move = this.engine.accel(value);
        record(move);
    }

    public void record(Move move) {
        if (move.equals(Move.FORWARD)) {
            this.carPosition = carPosition.plus(NaturalNumber.of(move.getAdditionalPosition()));
        }
    }

    public CarName getCarName() {
        return this.carName;
    }

    public NaturalNumber getCarPosition() {
        return carPosition;
    }
}
