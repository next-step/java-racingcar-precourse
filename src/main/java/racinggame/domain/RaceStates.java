package racinggame.domain;

public class RaceStates {
    private final Cars cars;

    public RaceStates() {
        this.cars = new Cars();
    }

    public Cars getCars() {
        return cars;
    }

    public void add(Car car) {
        this.cars.addCar(car);
    }
}
