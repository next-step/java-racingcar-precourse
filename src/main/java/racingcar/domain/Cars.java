package racingcar.domain;

import racingcar.constant.Constant;
import racingcar.constant.Message;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.Constant.WINNER_CAR_NAME_DELIMITER;

public class Cars {
    private final List<Car> carList;
    private final List<Car> winnerCars;


    public Cars(List<Car> participatingCars) {
        this.carList = participatingCars;
        this.winnerCars = new ArrayList<>();
    }

    public Cars(List<Car> carList, List<Car> winnerCars) {
        this.carList = carList;
        this.winnerCars = winnerCars;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinnerCarList() {
        return winnerCars;
    }


    public static Cars createParticipatingCars(String carNames) {
        validateCarNames(carNames);
        String[] cars = carNames.split(Constant.SEPERATOR);
        return new Cars(setParticipatingCars(cars));
    }

    private static void validateCarNames(String carNames) {
        if (Common.isEmpty(carNames)) {
            throw new IllegalArgumentException(Message.NOT_VALID_NULL);
        }
    }

    private static List<Car> setParticipatingCars(String[] carsNames) {
        List<Car> playCars = new ArrayList<>();
        for (String name : carsNames) {
            playCars.add(Car.createCar(name));
        }
        return playCars;
    }


    public int getWinnerScore() {
        int score = 0;
        for (Car car : carList) {
            score = score < car.getPosition() ? car.getPosition() : score;
        }
        return score;
    }

    public Cars setWinnerCars(int winnerScore) {
        for (Car car : carList) {
            if (winnerScore == car.getPosition()) {
                winnerCars.add(car);
            }
        }
        return new Cars(carList, winnerCars);
    }

    public static String getWinnerCarName(Cars winner) {
        List<String> winnerCarNames = new ArrayList<>();
        for (Car car : winner.getWinnerCarList()) {
            winnerCarNames.add(car.getCarName());
        }
        return String.join(WINNER_CAR_NAME_DELIMITER, winnerCarNames);
    }
}
