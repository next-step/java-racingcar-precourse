package racingcar.domain;

import racingcar.utils.RacingCarUtils;
import racingcar.view.RacingCarOutputView;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(String carNamesInput) {
        this.carList = new ArrayList<>();

        for (String carName : RacingCarUtils.splitName(carNamesInput)) {
            this.carList.add(new Car(carName));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void runRound() {
        for (Car car : carList) {
            car.runRound();
        }
    }

    public void getWinner() {
        int maxPosition = 0;
        StringBuffer winnerName = new StringBuffer();

        for (Car car : carList) {
            maxPosition = getMaxPositionAndWinner(maxPosition, winnerName, car);
        }
        RacingCarOutputView.outputWinner(winnerName.toString());
    }

    private int getMaxPositionAndWinner(int maxPosition, StringBuffer winnerName, Car car) {

        int carPosition = car.getDistance();

        if (isSamePosition(maxPosition, carPosition)) {
            winnerName.append(" " + car.getName());
        }

        if (isNewMaxPosition(maxPosition, carPosition)) {
            maxPosition = getNewMaxPosition(winnerName, car, carPosition);
        }
        return maxPosition;
    }

    private boolean isSamePosition(int maxPosition, int carPosition) {
        return maxPosition == carPosition;
    }

    private int getNewMaxPosition(StringBuffer winnerName, Car car, int carPosition) {
        winnerName.setLength(0);
        winnerName.append(car.getName());
        return carPosition;
    }

    private boolean isNewMaxPosition(int maxPosition, int carPosition) {
        return maxPosition < carPosition;
    }
}
