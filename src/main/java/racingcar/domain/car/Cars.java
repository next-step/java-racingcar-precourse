package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.contant.ExceptionMessage;
import racingcar.domain.fuel.FuelGenerator;

public class Cars {

    private final List<Car> racingCars;

    private Cars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public static Cars from(List<Car> racingCars) {
        validateCarSize(racingCars);
        return new Cars(racingCars);
    }

    private static void validateCarSize(List<Car> racingCars) {
        if (racingCars == null || racingCars.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_SIZE);
        }
    }

    public List<Car> findWinners() {
        Car winner = findAnyWinner();

        List<Car> winners = new ArrayList<>();
        for (Car racingCar : this.racingCars) {
            addSameDistanceWinner(winner, racingCar, winners);
        }

        return Collections.unmodifiableList(winners);
    }

    private Car findAnyWinner() {
        Car winner = this.racingCars.get(0);
        for (Car racingCar : this.racingCars) {
            winner = winner.findWinner(racingCar);
        }
        return winner;
    }

    private void addSameDistanceWinner(Car winner, Car racingCar, List<Car> winners) {
        if (winner.isSameDistance(racingCar)) {
            winners.add(racingCar);
        }
    }

    public void move(FuelGenerator fuelGenerator) {
        for (Car racingCar : this.racingCars) {
            racingCar.move(fuelGenerator.generate());
        }
    }

    public List<Car> getRacingCars() {
        return Collections.unmodifiableList(this.racingCars);
    }

    public List<String> findWinnerNames() {
        List<Car> winners = this.findWinners();
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName().name());
        }
        return winnerNames;
    }
}
