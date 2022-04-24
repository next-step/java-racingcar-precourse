package racingcar.domain;

import racingcar.constant.Configuration;
import racingcar.constant.ErrorMessage;

public class Car implements Comparable<Car> {
    private String name;
    private int distance;

    public Car(String name, int distance) {
        validateName(name);
        validateDistance(distance);
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void increaseDistance() {
        this.distance += 1;
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_OVER);
        }

        if (name.length() > Configuration.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_OVER);
        }
    }

    private void validateDistance(int distance) {
        if (distance != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DISTANCE);
        }
    }

    @Override
    public int compareTo(Car car) {
        if (this.distance > car.distance) {
            return -1;
        } else if (this.distance < car.distance) {
            return 1;
        }
        return 0;
    }
}
