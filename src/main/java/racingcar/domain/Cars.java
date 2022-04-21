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
        for (Car car : cars) {
            addToListIfWinner(winners, car, calcMaxMileage());
        }
        return String.join(",", winners);
    }

    private void addToListIfWinner(List<String> winners, Car car, Distance maxMileage) {
        if (maxMileage.equals(car.getMileage())) {
            winners.add(car.getName().toString());
        }
    }

    private Distance calcMaxMileage() {
        int max = 0;
        for (Car car : cars) {
            final String mileageAsSymbol = car.getMileageAsSymbol();
            max = Math.max(max, mileageAsSymbol.length());
        }
        return Distance.valueOf(max);
    }

    @Override
    public String toString() {
        return String.join("\n", cars.toString());
    }
}
