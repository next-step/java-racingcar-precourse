package racingcar.domain;

import static racingcar.util.Constans.CAR_FORWARD_CONDITION;
import static racingcar.util.Constans.CAR_FORWARD_VALUE;
import static racingcar.util.Constans.CAR_STOP_VALUE;
import static racingcar.util.Constans.SPLIT_CAR_NAME_DELIMITER;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> carList = new ArrayList<>();


    public void createCar(String inputValue) {
        String[] splitInputValue = inputValue.split(SPLIT_CAR_NAME_DELIMITER);
        for (String splitValue : splitInputValue) {
            carList.add(new Car(splitValue));
        }
    }


    public int forward(int randomeValue) {
        int count = CAR_STOP_VALUE;
        if (isForward(randomeValue)) {
            count = CAR_FORWARD_VALUE;
        }
        return count;
    }

    private boolean isForward(int randomeValue) {
        return randomeValue >= CAR_FORWARD_CONDITION;
    }

    public List<Car> getCarList() {
        return carList;
    }

}
