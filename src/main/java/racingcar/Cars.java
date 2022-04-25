package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final String CAR_NAME_SPLIT = ",";
    private final String FIANL_WINNER_SEPARATION = ", ";

    public List<Car> cars;
    private int maxCarPosition = 0;

    public Cars(String carNames) {
        cars = new ArrayList<Car>();
        String[] divideCarNames = divideCars(carNames);
        insertCarName(divideCarNames);
    }

    private String[] divideCars(String carNames) {
        String[] divideCarNames = carNames.split(CAR_NAME_SPLIT);

        return divideCarNames;
    }

    private void insertCarName(String[] divideCarNames) {
        for (String carName : divideCarNames) {
            cars.add(new Car(carName));
        }
    }

    public void checkGear() {
        for(Car car : cars) {
            int carPosition = 0;

            carPosition = car.checkGear();
            maxCarPosition = Math.max(maxCarPosition, carPosition);
        }
    }

    public String getFinalWinnerList() {
        StringBuilder finalWinnerList = new StringBuilder();

        for (Car car : cars) {
            String winner = "";
            String winnerSeparation = "";

            winner = isFinalWinner(car);
            winnerSeparation = isExistWinner(winner, finalWinnerList);

            finalWinnerList.append(winnerSeparation);
            finalWinnerList.append(winner);
        }

        return finalWinnerList.toString();
    }

    private String isFinalWinner(Car car) {
        if (this.maxCarPosition == car.getCarPosition()) return car.getCarName();

        return "";
    }

    private String isExistWinner(String winner, StringBuilder finalWinnerList) {
        if (winner.length() != 0 && finalWinnerList.length() != 0) return FIANL_WINNER_SEPARATION;

        return "";
    }
}
