package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private Cars cars;
    private int round;

    public Racing(String carNames, String inputRound) {
        cars = new Cars(carNames);
        this.round = Integer.parseInt(inputRound);
    }

    public int getRound() {
        return round;
    }

    public Cars move() {
        cars.move();
        return cars;
    }

    public Winner getWinner() {
        List<String> winner = new ArrayList<>();

        int max = cars.getMaxMileage();

        for (int i = 0; i < cars.size(); i++) {
            int mileage = cars.get(i).getMileage();
            if (max == mileage) {
                winner.add(cars.get(i).getName());
            }
        }

        return new Winner(winner);
    }
}
