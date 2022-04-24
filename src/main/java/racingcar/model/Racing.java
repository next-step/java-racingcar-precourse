package racingcar.model;

import racingcar.error.ErrorMessage;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Racing {
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String RACE_RESULT_TITLE_MESSAGE = "실행결과";
    private final int moveCount;
    private int maxCarDistance = 0;
    private final List<Car> cars;

    public Racing(String moveCount, List<Car> cars) {
        validNumber(moveCount);
        this.moveCount = Integer.parseInt(moveCount);
        this.cars = cars;
    }

    public static void validNumber(String moveCount) {
        if(!Pattern.matches(NUMBER_REGEX, moveCount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MOVE_COUNT.getMessage());
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            updateMaxCarDistance(car.move());
        }
    }

    public void updateMaxCarDistance(int distance) {
        if(maxCarDistance < distance) {
            maxCarDistance = distance;
        }
    }

    public List<Car> race() {
        System.out.println(RACE_RESULT_TITLE_MESSAGE);
        for(int i=0; i<moveCount; i++) {
            moveCars();
            System.out.println();
        }
        return getWinner();
    }

    public List<Car> getWinner() {
        return cars.stream().filter(car -> car.getDistance() == maxCarDistance).collect(Collectors.toList());
    }

    public int getMoveCount() {
        return moveCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxCarDistance() {
        return maxCarDistance;
    }
}
