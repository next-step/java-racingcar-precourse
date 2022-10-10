package racingcar.domain.car;

import racingcar.domain.game.GameRoundResult;
import racingcar.domain.strategy.CarMovingStrategy;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.NumberGenerateStrategy;
import racingcar.domain.strategy.RandomNumberGenerateStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static racingcar.domain.ErrorMessage.CARS_SIZE;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCarsWithNames(CarNames carNames) {
        validCarsSize(carNames.getSize());

        return new Cars(createCarList(carNames));
    }

    public static Cars createCarsWithCarList(List<Car> cars) {
        validCarsSize(cars.size());

        return new Cars(cars);
    }

    private static void validCarsSize(int size) {
        if (size < 2) {
            throw new IllegalArgumentException(CARS_SIZE);
        }
    }

    private static List<Car> createCarList(CarNames carNames) {
        List<Car> createdCares = new ArrayList<>();

        for (CarName carName : carNames.getCarNames()) {
            createdCares.add(Car.createCar(carName.getCarName()));
        }
        return createdCares;
    }

    public GameRoundResult carsPlayRound() {
        HashMap<CarName, CarPosition> playedOneRoundResultMap = new HashMap<>();
        NumberGenerateStrategy numberGenerateStrategy = new RandomNumberGenerateStrategy();
        MovingStrategy movingStrategy = new CarMovingStrategy();

        for (Car car : cars) {
            CarStatus carStatus = movingStrategy.getMoveStatus(numberGenerateStrategy.generateNumber());
            car.playRound(carStatus);
            playedOneRoundResultMap.put(car.getName(), car.getPosition());
        }

        return GameRoundResult.createGameRoundResult(playedOneRoundResultMap);
    }

    public CarNames getWinnerCarNames() {
        List<CarName> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            this.addWinnerCarName(winnerCars, car);
        }

        return CarNames.createCarNamesWithCarName(winnerCars);
    }

    public void addWinnerCarName(List<CarName> winnerCars, Car car) {
        CarPosition maxPosition = this.getMaxPosition();

        if (car.getPosition().isEquals(maxPosition)) {
            winnerCars.add(car.getName());
        }
    }

    private CarPosition getMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition().getIntPosition());
        }

        return CarPosition.createCarPosition(maxPosition);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
