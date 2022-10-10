package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private final String NAMES_SPLIT_REGEX = ",";

    public void run() {
        Cars cars = inputCars();
        Count count = inputCount();
        racing(cars, count);
    }

    private void racing(Cars cars, Count count) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < count.getCount(); i++) {
            cars.move();
            System.out.println(cars.toString());
        }
        printWinner(cars);
    }

    private void printWinner(Cars cars) {
        System.out.println("최종 우승자 : " + cars.findWinners().names());
    }

    public Cars inputCars() {
        try {
            String names = GameInput.inputNames();
            return carsOf(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCars();
        }
    }

    private Cars carsOf(String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names.split(NAMES_SPLIT_REGEX, -1)) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    public Count inputCount() {
        try {
            String count = GameInput.inputCount();
            return new Count(count);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCount();
        }
    }
}
