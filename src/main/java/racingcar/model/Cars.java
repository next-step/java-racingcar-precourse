package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void generateCars(String names) {
        CarNames carNames = CarNames.generate(names);
        for (CarName carName : carNames.get()) {
            Car car = Car.generate(carName, () -> Randoms.pickNumberInRange(1, 9));
            cars.add(car);
        }
    }

    public boolean isNotRegisteredCars() {
        return cars.isEmpty();
    }
}
