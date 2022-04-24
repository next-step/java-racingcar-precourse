package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.util.VisibleForTesting;
import racingcar.model.CarMoveRule;
import racingcar.model.CarName;
import racingcar.model.CurrentResult;
import racingcar.model.Message.ErrorMessage;
import racingcar.model.Position;
import racingcar.model.WinnerResult;

public class RacingCars {
    @VisibleForTesting
    ArrayList<RacingCar> cars = new ArrayList<>();
    ArrayList<CarName> winners = new ArrayList<>();

    public RacingCars(String carNameStr, CarMoveRule carMoveRule) {
        validCarNames(carNameStr);
        this.cars.addAll(convertCarsFromString(carNameStr, carMoveRule));
    }

    public RacingCars(ArrayList<RacingCar> cars) {
        this.cars.addAll(cars);
    }

    public void playRound() {
        cars.forEach(car -> car.move(RandomUtils.getRandomNumber()));
    }

    public void setWinners() {
        Position winnerPosition = getMaxPosition();
        for (RacingCar car : cars) {
            addWinner(car, winnerPosition);
        }
    }

    private void addWinner(RacingCar car, Position winnerPosition) {
        if (car.isWinner(winnerPosition)) {
            winners.add(car.getName());
        }
    }

    private Position getMaxPosition() {
        List<Integer> positions = new ArrayList<>();
        for (RacingCar racingCar : cars) {
            positions.add(racingCar.getGamePosition().getPosition());
        }
        return new Position(Collections.max(positions));
    }

    public WinnerResult getWinnerOutPutResult() {
        return new WinnerResult(winners);
    }

    private void validCarNames(String inputCarNames) {
        if (inputCarNames == null || inputCarNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_CAR_NAMES);
        }
    }

    private ArrayList<RacingCar> convertCarsFromString(String carNameStr, CarMoveRule carMoveRule) {
        String[] carNames = carNameStr.split(RacingCarConstants.CAR_NAME_DELIMITER);
        ArrayList<RacingCar> inputCars = new ArrayList<>();
        for (String carName : carNames) {
            inputCars.add(new RacingCar(carName, carMoveRule));
        }
        return inputCars;
    }

    public CurrentResult getCurrentResult() {
        return new CurrentResult(cars);
    }
}
