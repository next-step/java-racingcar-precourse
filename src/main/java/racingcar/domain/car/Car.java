package racingcar.domain.car;

import racingcar.domain.car.carname.CarName;
import racingcar.domain.car.move.Move;

public class Car {

    public static final String SEPARATOR = " : ";
    private CarName carName;
    private Move move;

    public Car(CarName carName, Move move) {
        this.carName = carName;
        this.move = move;
    }

    public String move(int random) {
        return carName() + SEPARATOR + move.move(random);
    }

    public int moveCount() {
        return move.moveCount();
    }

    public String carName() {
        return carName.toString();
    }

    public boolean isWinner(int moveCount) {
        return moveCount() == moveCount;
    }
}
