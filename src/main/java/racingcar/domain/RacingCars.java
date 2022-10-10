package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static racingcar.domain.RacingCarRule.CAR_RANDOM_MAX_NUMBER;
import static racingcar.domain.RacingCarRule.CAR_RANDOM_MIN_NUMBER;

public class RacingCars {
    protected final List<Car> cars;

    public RacingCars(String name) {
        this.cars = separateNameAndMakeCars(name);
    }

    public boolean isEqualNumberOfCar(int number) {
        return this.cars.size() == number;
    }

    public String finish(WinnerCondition condition) {
        if (cars.size() <= 0) {
            return "";
        }
        return condition.getWinners(this.cars, getMaxForwardCount());
    }

    public String race() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(CAR_RANDOM_MIN_NUMBER, CAR_RANDOM_MAX_NUMBER);
            sb.append(car.move(randomNumber, new CarForwardStrategy())).append("\n");
        }
        return sb.toString();
    }

    private int getMaxForwardCount() {
        int max = 0;
        for (Car car : this.cars) {
            max = Math.max(max, car.getForwardCount());
        }
        return max;
    }

    private List<Car> separateNameAndMakeCars(String name) {
        List<Car> cars = new ArrayList<>();
        String[] names = name.split(",");

        for (String separatedName : names) {
            cars.add(new Car(separatedName));
        }

        return cars;
    }
}
