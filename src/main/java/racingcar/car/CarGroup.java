package racingcar.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;

public class CarGroup {

    private static final Pattern PATTERN = Pattern.compile(",");

    private final List<Car> cars;

    private CarGroup(List<Car> cars) {
        this.cars = requireNonNull(cars, "cars");
    }

    protected CarGroup(String value) {
        this(toCars(value));
    }

    public static CarGroup of(String value) {
        return new CarGroup(value);
    }

    public List<Car> asList() {
        return Collections.unmodifiableList(cars);
    }

    public void forEach(Consumer<Car> action) {
        cars.forEach(action);
    }

    private static List<Car> toCars(String value) {
        final String[] carNames = toCarNames(value);
        final List<Car> cars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            cars.add(Car.of(carName));
        }
        return cars;
    }

    private static String[] toCarNames(String value) {
        if (value == null || value.isEmpty()) {
            throw new InvalidCarNameOfCarGroupException(null);
        }
        final String[] carNames = PATTERN.split(value);
        if (carNames.length == 0) {
            throw new InvalidCarNameOfCarGroupException(value);
        }
        return carNames;
    }
}
