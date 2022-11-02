package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.util.ValidUtils;

public class Cars {
    private static final String LINE_SEPARATOR = "line.separator";

    private final List<Car> cars;

    public Cars(String inputCarNames) {
        ValidUtils.validDuplicateSeparator(inputCarNames);
        String[] carNames = ValidUtils.validDuplicateName(inputCarNames);
        ValidUtils.validParticipateCarCount(carNames);
        this.cars = mapCars(carNames);
    }

    private List<Car> mapCars(String[] carNames) {
        List<Car> newCars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(new CarName(carName));
            newCars.add(car);
        }
        return newCars;
    }

    public CarPosition getMaxPosition() {
        CarPosition maxPosition = new CarPosition(0);
        for (Car car : cars) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }

    public Winners findWinners(CarPosition maxPosition) {
        return new Winners(cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList()));
    }

    public PlayResult playRound(MovingStrategy movingStrategy) {
        PlayResult result = new PlayResult();
        for (Car car : cars) {
            car.move(movingStrategy);
        }
        result.roundResult(this);
        return result;
    }

    public PlayResult finishGame() {
        PlayResult result = new PlayResult();
        result.gameResult(findWinners(getMaxPosition()));
        return result;
    }

    public String roundResult() {
        StringBuilder roundState = new StringBuilder();
        cars.forEach(car -> {
            roundState.append(car.getState());
            roundState.append(System.getProperty(LINE_SEPARATOR));
        });
        return roundState.toString();
    }

    public List<Car> getCars() {
        return cars;
    }
}
