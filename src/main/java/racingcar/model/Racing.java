package racingcar.model;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Racing {
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private final int moveCount;
    private int maxCarDistance = 0;
    private final List<Car> cars;

    public Racing(String moveCount, List<Car> cars) {
        if(!isNumber(moveCount)) {
            throw new IllegalArgumentException();
        }
        this.moveCount = Integer.parseInt(moveCount);
        this.cars = cars;
    }

    private boolean isNumber(String input) {
        return Pattern.matches(NUMBER_REGEX, input);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
            updateMaxCarDistance(maxCarDistance);
        }
    }

    public void updateMaxCarDistance(int distance) {
        if(maxCarDistance < distance) {
            maxCarDistance = distance;
        }
    }

    public List<Car> race() {
        for(int i=0; i<moveCount; i++) {
            moveCars();
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
