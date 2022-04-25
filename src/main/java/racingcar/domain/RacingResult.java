package racingcar.domain;

import racingcar.common.Messages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingResult {
    private final List<RacingCar> cars;
    private final List<String> winners = new ArrayList<>();

    public RacingResult(List<RacingCar> cars) {
        this.cars = cars;
    }

    public String winners() {
        int winnerLocation = maxLocation();

        for (RacingCar car : cars) {
            addWinner(car, winnerLocation);
        }

        return String.format("%s %s", Messages.RACING_WINNER, String.join(",", winners));
    }

    private void addWinner(RacingCar car, int winnerLocation) {
        if (car.getCurrentLocation() == winnerLocation) winners.add(car.getCarName());
    }

    private int maxLocation() {
        List<Integer> carLocations = new ArrayList<>();
        for (RacingCar car : cars) {
            carLocations.add(car.getCurrentLocation());
        }

        return Collections.max(carLocations);
    }
}
