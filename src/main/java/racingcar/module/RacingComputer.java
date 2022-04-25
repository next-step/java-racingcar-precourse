package racingcar.module;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RacingCar;

public class RacingComputer {

    private final int count;

    private final List<RacingCar> cars = new ArrayList<>();

    public RacingComputer(String carNames, int count) {
        for (String carName : carNames.split(",")) {
            RacingCar racingCar = new RacingCar(carName);
            this.cars.add(racingCar);
        }
        this.count = count;
    }

    public List<RacingCar> getCars() {
        return this.cars;
    }

    public void compute() {
        for (int i = 0; i < this.count; i++) {
            for (RacingCar car : this.cars) {
                car.move();
            }
        }
    }

    public List<String> getWinnerNames() {
        int maxMove = getMaxMoved();
        List<String> winners = new ArrayList<>();

        for (RacingCar car : this.cars) {
            Integer moved = car.getMoved();

            if (moved == maxMove) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int getMaxMoved() {
        int maxMoved = 0;

        for (RacingCar car : this.cars) {
            Integer moved = car.getMoved();

            if (moved > maxMoved) {
                maxMoved = moved;
            }
        }

        return maxMoved;
    }
}
