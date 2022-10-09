package racingcar.domain;

import java.util.*;

public class Entry {
    private static final int MIN_CAR_LENGTH = 1;
    private static final String CAR_NAME_SPLITTER = ",";
    static final String INVALID_CAR_NAMES_MESSAGE = String.format("경주할 자동차 이름을 중복 없이 쉼표(%s)로 구분해서 %d대 이상 입력해주세요.",
                                                                  CAR_NAME_SPLITTER, MIN_CAR_LENGTH);

    private final List<Car> cars;

    private Entry(List<Car> cars) {
        this.cars = cars;
    }

    public static Entry from(String value) {
        List<Car> cars = mapCars(value);
        validate(cars);
        return new Entry(cars);
    }

    private static List<Car> mapCars(String value) {
        String[] carNames = splitCarNames(value);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.from(carName));
        }
        return cars;
    }

    //@formatter:off
    private static String[] splitCarNames(String value) {
        return Optional.ofNullable(value)
                .filter(s -> !s.startsWith(CAR_NAME_SPLITTER) && !s.endsWith(CAR_NAME_SPLITTER))
                .map(s -> s.split(CAR_NAME_SPLITTER))
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CAR_NAMES_MESSAGE));
    }
    //@formatter:on

    private static void validate(List<Car> cars) {
        int size = cars.size();
        if (size < MIN_CAR_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAMES_MESSAGE);
        }
        if (size != new HashSet<>(cars).size()) {
            throw new IllegalArgumentException(INVALID_CAR_NAMES_MESSAGE);
        }
    }

    public List<String> race(Movement movement) {
        List<String> carPositions = new ArrayList<>();
        for (Car car : cars) {
            carPositions.add(car.race(movement));
        }
        return Collections.unmodifiableList(carPositions);
    }

    public List<String> winners() {
        int winnerPosition = findWinnerPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addCarIfWinner(winners, car, winnerPosition);
        }
        return Collections.unmodifiableList(winners);
    }

    private int findWinnerPosition() {
        int winnerPosition = 0;
        for (Car car : cars) {
            winnerPosition = Math.max(winnerPosition, car.getPosition());
        }
        return winnerPosition;
    }

    private void addCarIfWinner(List<String> winners, Car car, int winnerPosition) {
        if (car.isWinner(winnerPosition)) {
            winners.add(car.getName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entry entry = (Entry) o;
        return Objects.equals(cars, entry.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "cars=" + cars +
                '}';
    }
}
