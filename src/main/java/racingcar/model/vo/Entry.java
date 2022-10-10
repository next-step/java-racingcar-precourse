package racingcar.model.vo;

import java.util.HashSet;
import java.util.List;
import racingcar.model.constants.ErrorMessage;

public class Entry {

    private final List<Car> entry;

    public Entry(List<Car> entry) throws IllegalArgumentException {
        if (!checkDuplication(entry)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_PREFIX + ErrorMessage.CAR_DUPLICATE);
        }
        this.entry = entry;
    }

    protected static boolean checkDuplication(List<Car> entry) {
        HashSet<String> cars = new HashSet<>();
        for (Car car : entry) {
            String carName = car.getCarName();
            if (cars.contains(carName)) {
                return false;
            }
            cars.add(carName);
        }
        return true;
    }

    public List<Car> getEntry() {
        return entry;
    }
}
