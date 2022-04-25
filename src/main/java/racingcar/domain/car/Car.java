package racingcar.domain.car;

import racingcar.domain.engine.Engine;
import racingcar.vo.racenumber.RaceNumber;

public class Car {
    private Name name;
    private Distance distance;
    private Engine engine;

    public Car(String name, int initDistance, Engine engine) {
        this.name = Name.from(name);
        this.distance = Distance.from(initDistance);
        this.engine = engine;
    }

    public void move(RaceNumber raceNumber) {
        this.distance.add(engine.goForward(raceNumber));
    }

    public Distance getDistance() {
        return this.distance;
    }

    public Name getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car that = (Car) o;
        return name.equals(that.name);
    }
}
