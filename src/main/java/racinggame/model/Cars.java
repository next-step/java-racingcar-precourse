package racinggame.model;

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
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() == maxPosition) {
                winnerCarList.add(carList.get(i));
            }
        }
        return winnerCarList;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() > maxPosition) {
                maxPosition = carList.get(i).getPosition();
            }
        }
        return maxPosition;
    }
}
