package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private static final String DELIMITER = ",";
    private final List<Car> carList = new ArrayList<>();

    public CarList(String carNameList) {
        for (String name : carNameList.split(DELIMITER)) {
            carList.add(new Car(name));
        }
    }

    public CarList(List<Car> winners) {
        carList.addAll(winners);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
