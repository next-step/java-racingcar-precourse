package racingcar.domain;

import java.util.Objects;

import static racingcar.constant.GameConfig.CAR_MOVE_STRING;

public class Car {

    private final String name;
    private int winCount;

    public Car(final String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }
    public int getWinCount() {
        return winCount;
    }

    public String move(final int randomNumber) {
        stopAndGo(randomNumber);
        StringBuilder moveStr = new StringBuilder(name + " : ");
        for (int i = 0; i < winCount; i++) {
            moveStr.append(CAR_MOVE_STRING);
        }
        return moveStr.toString();
    }

    public void stopAndGo(final int randomNumber) {
        if (randomNumber >= 4) {
            winCount++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return winCount == car.winCount && name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, winCount);
    }
}
