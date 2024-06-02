package models;

import java.util.ArrayList;
import java.util.List;

import io.Result;
import utils.RandomGenerator;

public class Race {
    private final List<Car> cars = new ArrayList<>();

    public Race(String[] carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void start(int moves) {
        for (int i = 0; i < moves; i++) {
            for (Car car : cars) {
                car.move(RandomGenerator.generateRandomNumber());
            }
            Result.printRoundResult(cars);
        }
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int winnerPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);

        for (Car car :  cars) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }


}
