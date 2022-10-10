package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import static racingcar.view.ConsoleOutput.printMessage;

public class Cars {

    List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public Cars(final List<String> names) {
        this();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public int size() {
        return cars.size();
    }
    public int move(final List<Integer> randomNumbers) {
        int carSize = size();
        int mostWinCount = 0;
        for (int i = 0; i < carSize; i++) {
            int number = randomNumbers.get(i);
            Car car = cars.get(i);
            printMessage(car.move(number));
            mostWinCount = Math.max(car.getWinCount(), mostWinCount);
        }
        return mostWinCount;
    }

    public List<Car> winners(final int mostMoveCount) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            compareWinner(mostMoveCount, winners, car);
        }
        return winners;
    }

    private void compareWinner(final int mostMoveCount, final List<Car> winners, final Car car) {
        if (car.getWinCount() == mostMoveCount) {
            winners.add(car);
        }
    }
}
