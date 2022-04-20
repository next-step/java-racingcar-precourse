package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private final List<Car> cars = new ArrayList<>();

    public void lineUpCars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void processRound() {
        for (Car car : cars) {
            final int pickedNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            car.drive(pickedNumber);
        }
    }

    public String findWinners() {
        final List<String> winners = new ArrayList<>();
        final int maxMileage = calcMaxMileage();
        for (Car car : cars) {
            addToListIfWinner(winners, car, maxMileage);
        }
        return String.join(",", winners);
    }

    private void addToListIfWinner(List<String> winners, Car car, int maxMileage) {
        if (maxMileage == car.calcMileage()) {
            winners.add(car.getName().toString());
        }
    }

    private int calcMaxMileage() {
        int max = 0;
        for (Car car : cars) {
            final String mileageAsSymbol = car.calcMileageAsSymbol();
            max = Math.max(max, mileageAsSymbol.length());
        }
        return max;
    }

    @Override
    public String toString() {
        return String.join("\n", cars.toString());
    }
}
