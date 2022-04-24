package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.global.errorcode.ErrorCode;
import racingcar.model.CarNameSplit;
import racingcar.model.GameRule;

public class Cars {

    private static final String POSITION_MESSAGE = "-";
    private List<Car> values;


    public Cars(CarNameSplit carNameSplit) {
        values = new ArrayList<>();
        nullValidation(carNameSplit);

        for (String car : carNameSplit.getCarNames()) {
            values.add(new Car(car));
        }
    }

    public Cars(Cars cars) {
        this.values = cars.values;
    }

    private void nullValidation(CarNameSplit carNameSplit) {
        if (carNameSplit.getCarNames() == null) {
            throw new IllegalArgumentException(ErrorCode.ILLEGAL_CAR_NULL.getMessage());
        }

        if (carNameSplit.getCarNames().size() <= 0) {
            throw new IllegalArgumentException(ErrorCode.ILLEGAL_CAR_NULL.getMessage());
        }
    }

    public void runGame(GameRule gameRule) {
        values.forEach(car -> car.moveCar(gameRule));
    }

    public void carMovingMessage(int tryCount) {
        for (Car car : values) {
            String movingMessage = String.format("%s : %s",
                    car.getCarName(),
                    convertingToPositionMessage(car.getCurrentPosition(tryCount)));
            System.out.println(movingMessage);
        }
    }

    private String convertingToPositionMessage(int carPosition) {
        StringBuilder carPositionSignature = new StringBuilder();
        for (int index = 0; index < carPosition; index++) {
            carPositionSignature = carPositionSignature.append(POSITION_MESSAGE);
        }
        return carPositionSignature.toString();
    }


    public Car getWinner() {
        Car winner = null;
        for (Car car : values) {
            winner = car.getWinnerCar(winner);
        }
        return winner;
    }

    public List<Car> getSameScoreCars(Car winnerCar) {
        List<Car> jointWinner = new ArrayList<>();
        for (Car car : values) {
            addJointWinnerCar(jointWinner, winnerCar, car);
        }
        return jointWinner;
    }

    private void addJointWinnerCar(List<Car> jointWinner, Car winnerCar, Car comparableCar) {
        if (winnerCar.isJointWinner(comparableCar)) {
            jointWinner.add(comparableCar);
        }
    }

}
