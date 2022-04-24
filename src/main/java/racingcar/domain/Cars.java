package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final int MOVE_NUMBER_MIN_RANGE = 0;
    private static final int MOVE_NUMBER_MAX_RANGE = 9;
    private static final int POSITION_START_VALUE = 0;

    private List<Car> cars = new ArrayList<>();

    private List<Car> winners = new ArrayList<>();

    public Cars(String[] carNames) {
        for (String name : carNames) {
            addCar(name);
        }
    }

    private void addCar(String name) {
        this.cars.add(new Car(name));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void playRound() {
        for (Car car : this.cars) {
            int moveNumber = getRandomNumber();
            car.judgeAndMove(moveNumber);
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MOVE_NUMBER_MIN_RANGE, MOVE_NUMBER_MAX_RANGE);
    }


    public void findWinners() {
        int highPosition = findHighPosition();
        for (Car car : this.cars) {
            addWinnerWhenHighPosition(car, highPosition);
        }
    }

    private int findHighPosition() {
        int highPosition = POSITION_START_VALUE;
        for (Car car : this.cars) {
            highPosition = car.compareHighPosition(highPosition);
        }
        return highPosition;
    }

    private void addWinnerWhenHighPosition(Car car, int highPosition) {
        if (car.getPosition() == highPosition) {
            this.winners.add(car);
        };
    }

    public List<Car> getWinners() {
        return winners;
    }

    public List<String> getWinnerNames() {
        List<String> winners = new ArrayList<>();
        for (Car winner : this.winners) {
            winners.add(winner.getName());
        }
        return winners;
    }

}
