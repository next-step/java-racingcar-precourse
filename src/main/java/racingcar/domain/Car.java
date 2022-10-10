package racingcar.domain;

import racingcar.rule.GoStop;

public class Car {
    private final Name name;
    private final Distance distance;

    public Car(String name) {
        this.name = new Name(name);
        this.distance = new Distance();
    }

    public Name getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }

    private void go() {
        this.distance.go();
    }

    private void stop() {
        this.distance.stop();
    }

    public int compare(Car car) {
        return this.distance.compare(car.distance);
    }

    public void goOrStop(GoStop goStop) {
        if (GoStop.GO == goStop) {
            this.go();
            return;
        }
        this.stop();
    }
}
