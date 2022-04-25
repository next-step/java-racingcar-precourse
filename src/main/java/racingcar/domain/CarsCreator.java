package racingcar.domain;

public class CarsCreator {

    private static final String COMMA = ",";

    private CarsCreator() {
    }

    public static CarsCreator create() {
        return new CarsCreator();
    }

    public Cars createCarsBy(String carNames) {
        String[] names = carNames.split(COMMA);
        Cars cars = Cars.empty();

        for (String name : names) {
            cars.add(Car.withName(name));
        }

        return cars;
    }
}
