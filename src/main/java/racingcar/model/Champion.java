package racingcar.model;

public final class Champion {
    private final Cars cars;

    private Champion(Cars cars) {
        this.cars = pickParticularPositionCar(cars);
    }

    public static Champion pick(Cars cars) {
        return new Champion(cars);
    }

    public Cars announce() {
        return cars;
    }

    static Position getMaxPosition(Cars cars) {
        return cars.getMaxPosition();
    }

    static Cars pickParticularPositionCar(Cars cars) {
        return cars.getParticularPosition(getMaxPosition(cars));
    }
}
