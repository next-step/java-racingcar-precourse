package racingcar.domain;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final String NOT_SAME_SIZE_ERROR_MESSAGE = "[ERROR] 자동차의 수와 입력된 랜덤 값의 수는 같아야 한다.";
    private static final String DUPLICATE_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없다.";

    private final Set<Car> cars = new LinkedHashSet<>();

    public Cars(String names) {
        String nameRegex = ",";
        for (String name : names.split(nameRegex)) {
            Car car = new Car(name);
            checkDuplicateCar(car);
            cars.add(car);
        }
    }

    public MoveResult moveForward(List<Integer> numbers) {
        if (isNotSameSize(numbers)) {
            throw new IllegalArgumentException(NOT_SAME_SIZE_ERROR_MESSAGE);
        }

        MoveResult moveResult = new MoveResult();

        int i = 0;
        for (Car car : cars) {
            car.moveForward(numbers.get(i++));
            moveResult.add(car.getName(), car.getMoveCount());
        }

        return moveResult;
    }

    public Victors getVictors() {
        Victors victors = new Victors();
        for (Car car : cars) {
            addVictors(victors, car);
        }
        return victors;
    }

    public int size() {
        return cars.size();
    }

    private void addVictors(Victors victors, Car car) {
        if (isMaxMoveCount(car.getMoveCount())) {
            victors.add(car.getName());
        }
    }

    private boolean isMaxMoveCount(int moveCount) {
        return moveCount == getMaxMovCount();
    }

    private int getMaxMovCount() {
        int maxMoveCount = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }
        return maxMoveCount;
    }

    private void checkDuplicateCar(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    private boolean isNotSameSize(List<Integer> numbers) {
        return cars.size() != numbers.size();
    }
}
