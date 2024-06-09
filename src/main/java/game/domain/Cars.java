package game.domain;

import game.config.constant.Rule;
import game.exception.constant.ErrorMessage;
import game.util.RandomNumberGenerator;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Cars {

    private List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars fromCarNames(List<String> carNames) {
        return new Cars(carNames.stream().map(Car::new).toList());
    }

    public static Cars fromCarList(List<Car> carList) {
        return new Cars(carList);
    }

    public void move() {
        carList.forEach(car -> car.move(RandomNumberGenerator.getNumber(Rule.MAX_RANDOM_VALUE)));
    }

    public Cars findWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = carList.stream()
            .filter(car -> car.isWinner(maxPosition))
            .toList();
        return new Cars(winners);
    }

    public int getMaxPosition() {
        return carList.stream()
            .map(Car::getPosition)
            .max(Comparator.naturalOrder())
            .orElseThrow(() -> new NoSuchElementException(ErrorMessage.EMPTY_LIST.getMessage()));
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    /**
     * 리스트의 순서와 상관없이 내부 원소만 비교하여 동등성을 판단합니다
     *
     * @param o 비교할 Cars 인스턴스
     * @return 동등여부
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars = (Cars) o;
        return new HashSet<>(carList).equals(new HashSet<>(cars.getCarList()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(carList);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cars = ");
        carList.forEach(car ->
            stringBuilder.append("(")
                .append(car.getName())
                .append(", position: ")
                .append(car.getPosition())
                .append(")"));
        return stringBuilder.toString();
    }
}
