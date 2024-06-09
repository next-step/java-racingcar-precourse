package racingcar.application.port;

import racingcar.domain.Car;

public class CarResponse {
    private final String name;
    private final int position;

    public CarResponse(final Car car) {
        this.name = car.name().value();
        this.position = car.position().value();
    }

    public String name() {
        return this.name;
    }

    public int position() {
        return this.position;
    }
}
