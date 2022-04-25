package racingcar.car;

import static racingcar.utils.ObjectUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import racingcar.game.InputCarNames;
import racingcar.racing.RoundResult;
import racingcar.racing.RoundResults;

public class Cars {
    private List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars init() {
        return new Cars(new ArrayList<>());
    }

    public static Cars valueOf(final InputCarNames carNames) {
        validateInputCarNames(carNames);
        return new Cars(carNames.mapTo(Car::of));
    }

    public static Cars of(final List<Car> carList) {
        validateCarList(carList);
        return new Cars(carList);
    }

    public RoundResults goOrStopAll() {
        final RoundResults roundResults = RoundResults.init();
        for (Car car : cars) {
            roundResults.result(RoundResult.report(car, car.race()));
        }
        return roundResults;
    }

    public void addCar(final Car car) {
        this.cars.add(car);
    }

    public void each(final Consumer<Car> carConsumer) {
        for (Car car : cars) {
            carConsumer.accept(car);
        }
    }

    public <T> List<T> mapToList(final Function<Car, T> function) {
        List<T> mapList = new ArrayList<>();
        for (Car car : cars) {
            mapList.add(function.apply(car));
        }
        return mapList;
    }

    public int countCars() {
        return this.cars.size();
    }

    private static void validateInputCarNames(final InputCarNames carNames) {
        if (isEmpty(carNames)) {
            throw new IllegalArgumentException("[ERROR] 입력자동차 이름이 null 일 수는 없습니다.");
        }
    }

    private static void validateCarList(final List<Car> carList) {
        if (carList.size() == 0) {
            throw new IllegalArgumentException("[ERROR] 자동차를 최소 한 개 이상 포함시켜주세요.");
        }
    }

    public Car getCarByIndex(final int index) {
        return this.cars.get(index);
    }
}
