package racingcar.domain;

import java.util.List;
import racingcar.constants.MessageConstants;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        validateNullOrEmpty(carList);
        this.carList = carList;
    }

    private void validateNullOrEmpty(List<Car> carList) {
        if(carList == null || carList.isEmpty()) {
            throw new IllegalArgumentException(MessageConstants.ERROR_MESSAGE_CAR_LIST_NULL_EMPTY);
        }
    }

    public int size() {
        return carList.size();
    }

    public Car get(IndexNumber index) {
        return carList.get(index.getIndexNumber());
    }
}
