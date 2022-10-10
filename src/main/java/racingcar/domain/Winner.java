package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    int maxPosition = 0;
    private ArrayList<String> winnerCars = new ArrayList<>();

    private void getWinnerPosition(List<Car> carList) {
        for (Car car : carList) {
            if (isMaxPosition(car.getPosition())) {
                maxPosition = car.getPosition();
            }
        }
    }

    private boolean isMaxPosition(int position) {
        return maxPosition < position;
    }


    public void getWinnerCars(List<Car> carList) {
        getWinnerPosition(carList);
        for (Car car : carList) {
            if (isEqualsPosition(car.getPosition())) {
                winnerCars.add(car.getName());
            }
        }
    }

    private boolean isEqualsPosition(int position) {
        return maxPosition == position;
    }

    public ArrayList<String> getWinnerCars() {
        return winnerCars;
    }
}
