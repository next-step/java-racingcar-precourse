package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private static final int ZERO = 0;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validCarsList(cars);
        this.cars = cars;
    }

    public static Cars addCarList(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars addCarListByStringCarNames(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : StringUtils.splitByComma(carNames)) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public List<Car> race() {
        for (Car car : cars) {
            advanceOrStop(car);
        }
        return cars;
    }

    private void advanceOrStop(Car car) {
        RandomNum randomNum = new RandomNum();
        if (randomNum.isMoreNumber()) {
            car.advance();
        }
    }

    public String getWinnerName() {
        List<String> winner = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : cars) {
            addIfEqualMaxPosition(winner, car, maxPosition);
        }
        return StringUtils.joinByComma(winner);
    }

    private void addIfEqualMaxPosition(List<String> winner, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winner.add(car.getCarName());
        }
    }

    private int getMaxPosition() {
        int maxPosition = ZERO;
        for (Car car : cars) {
            maxPosition = changeIfOverMaxPosition(car.getPosition(), maxPosition);
        }
        return maxPosition;
    }

    private int changeIfOverMaxPosition(int position, int maxPosition) {
        return Math.max(position, maxPosition);
    }

    private void validCarsList(List<Car> cars) {
        if (cars == null || cars.size() == 0) {
            throw new IllegalArgumentException("최소 하나의 자동차를 입력받아야 합니다.");
        }
    }

    public int size() {
        return cars.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return cars.equals(cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
