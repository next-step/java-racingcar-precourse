package racingcargame.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarNames implements Iterable<CarName> {
    public static final String DELIMITER = ",";
    List<CarName> carNames;

    private CarNames(List<CarName> carNames) {
        this.carNames = carNames;
    }

    public static CarNames of(String carNamesInput) {
        List<CarName> carNames = new ArrayList<>();
        for (String carName : carNamesInput.split(DELIMITER)
        ) {
            carNames.add(CarName.of(carName));
        }
        return new CarNames(carNames);
    }

    @Override
    public Iterator<CarName> iterator() {
        return carNames.iterator();
    }
}
