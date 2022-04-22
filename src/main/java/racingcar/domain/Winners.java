package racingcar.domain;

import java.util.List;
import java.util.StringJoiner;

public class Winners {
    private static final String NAME_PRINT_SEPARATOR = ", ";
    private final List<Car> values;

    private Winners(List<Car> values) {
        this.values = values;
    }

    public static Winners from(List<Car> cars) {
        return new Winners(cars);
    }

    public String getNames() {
        StringJoiner result = new StringJoiner(NAME_PRINT_SEPARATOR);
        for (Car car : this.values) {
            result.add(car.getName());
        }
        return result.toString();
    }
}
