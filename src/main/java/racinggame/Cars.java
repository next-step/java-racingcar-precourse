package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public Cars(String carNames) {
        String[] carNameArr = carNames.split(",");
        for (String carName : carNameArr) {
            carList.add(new Car(carName));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getCarsLength() {
        return carList.size();
    }

    public List<Car> getWinnerCarList() {
        List<Car> winnerCarList = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winnerCarList.add(car);
            }
        }
        return winnerCarList;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }


}
