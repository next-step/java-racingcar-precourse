package racingcar.domain.input;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class InputCarName implements Input<Cars> {

    public static final String REGEX = ",";

    private final String input;

    public InputCarName(String input) {
        this.validateBlank(input);
        this.input = input;
    }

    @Override
    public Cars create() {
        String[] carNames = splitCarName();
        List<Car> cars = getCars(carNames);
        return new Cars(cars);
    }

    private List<Car> getCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private String[] splitCarName() {
        return this.input.split(REGEX);
    }

}
