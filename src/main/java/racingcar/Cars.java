package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final String SEPARATOR = ",";
    private List<Car> cars;

    public Cars(String carNames) {
        String[] splitCarNames = carNames.split(SEPARATOR);
        this.cars = convertCar(splitCarNames);
    }

    private List<Car> convertCar(String[] splitCarNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < splitCarNames.length; i++) {
            cars.add(new Car(splitCarNames[i]));
        }
        return cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getCarsSize() {
        return this.cars.size();
    }

    public void play() {
        for (Car car : this.cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
        System.out.println();
    }

    public List<String> getWinners(int attemptCount) {
        List<String> winners = new ArrayList<>();
        for (Car car : this.cars) {
            checkAndSetCar(car, attemptCount, winners);
        }
        return winners;
    }

    private void checkAndSetCar(Car car, int attemptCount, List<String> winners) {
        if (car.isMovementSame(attemptCount)) {
            winners.add(car.getCarName());
        }
    }
}
