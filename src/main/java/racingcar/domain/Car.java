package racingcar.domain;

import racingcar.domain.engine.Engine;
import racingcar.domain.engine.MoveStatus;

public class Car {
    private Name name;
    private Distance distance;
    private Engine engine;

    private Car(Name name) {
        this.name = name;
        this.distance = Distance.empty();
    }

    private Car(Name name, Engine engine) {
        this.name = name;
        this.engine = engine;
        this.distance = Distance.empty();
    }

    public static Car from(Name name) {
        return new Car(name);
    }

    public static Car of(Name name, Engine engine) {
        return new Car(name, engine);
    }

    public String getName() {
        return this.name.getValue();
    }

    public Integer getDistance() {
        return this.distance.getValue();
    }

    public void run() {
        MoveStatus moveStatus = this.engine.run();
        this.distance.update(moveStatus);
    }
}
