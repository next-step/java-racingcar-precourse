package racingcar;

import console.PrintOutput;
import utils.RandomNumberGenerator;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void play(RandomNumberGenerator generator) {
        for (Car car : cars) {
            car.isMovable(generator.create());
            PrintOutput.gameStatus(car);
        }
    }

    public String getWinner() {
        int max = getMaxPosition();
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(checkWinner(car, max));
        }

        return sb.substring(0, sb.length() - 1);
    }

    private String checkWinner(Car car, int max) {
        return car.getPosition() == max ? car.getName() + "," : "";
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }

        return max;
    }
}
