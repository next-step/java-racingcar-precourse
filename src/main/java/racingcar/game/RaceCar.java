package racingcar.game;

import racingcar.car.Car;
import racingcar.car.CarName;
import racingcar.game.round.MoveStack;
import racingcar.game.round.Round;
import racingcar.game.round.Turn;

import java.util.Optional;

public class RaceCar {

    private final Car car;
    private final MoveStack moveStack;

    private RaceCar(Car car, Round round) {
        this.car = car;
        this.moveStack = MoveStack.of(round);
    }

    public static RaceCar entry(Car car, Round round) {
        return new RaceCar(car, round);
    }

    public CarName name() {
        return this.car.name();
    }

    public boolean isFinish() {
        return this.moveStack.isFull();
    }

    public void go(Turn.Type type) {
        if (Turn.Type.GO.equals(type)) {
            this.moveStack.add();
        }

        Printer.moveStatus(this);
    }

    public MoveStack moveStack() {
        return this.moveStack;
    }

    public Optional<RaceCar> ifFinish() {
        if (isFinish()) {
            return Optional.of(this);
        }

        return Optional.empty();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RaceCar)) {
            return false;
        }

        return ((RaceCar) obj).car.equals(this.car);
    }

    @Override
    public int hashCode() {
        return this.car.hashCode();
    }

}
