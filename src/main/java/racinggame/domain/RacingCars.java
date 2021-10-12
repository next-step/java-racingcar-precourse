package racinggame.domain;

import nextstep.utils.Randoms;
import racinggame.config.ErrorMessage;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static racinggame.config.GameConfig.*;
import static racinggame.dto.GameView.printRaceResult;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.validateDuplicate(cars);
        this.cars = cars;
    }

    private void validateDuplicate(List<Car> cars) {
        Set<Car> carSet = new LinkedHashSet<>(cars);
        if (carSet.size() < cars.size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_CAR_NAME_DUPLICATE.getValue());
        }
    }

    public String race(AttemptCount attemptCount) {
        for (int i = 0; i < attemptCount.getCount(); i++) {
            this.takeOneTurn();
            this.getRacingCarView();
        }
        return this.getWinners();
    }

    private void takeOneTurn() {
        for (Car car : cars) {
            this.moveCar(car);
        }
    }

    private void moveCar(Car car) {
        if (Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START, RANDOM_NUMBER_RANGE_END)
                >= NUMBER_CONDITION_GO) {
            car.move(1);
        }
    }

    private String getWinners() {
        List<String> winners = new ArrayList<>();

        int maxDistance = this.findMaxDistance();
        for (Car car : cars) {
            winners.addAll(this.findWinner(car, maxDistance));
        }

        return String.join(",", winners);
    }

    private List<String> findWinner(Car car, int maxDistance) {
        List<String> winners = new ArrayList<>();
        if (this.checkWinnerDistance(maxDistance, car.getDistance())) {
            winners.add(car.getCarName());
        }
        return winners;
    }

    private boolean checkWinnerDistance(int maxDistance, int distance) {
        return maxDistance == distance;
    }

    private int findMaxDistance() {
        int max = Integer.MIN_VALUE;
        for (Car car : cars) {
            max = Math.max(car.getDistance(), max);
        }
        return max;
    }

    private void getRacingCarView() {
        for (Car car : cars) {
            printRaceResult(car.getCarStatus());
        }
        System.out.println();
    }

    public List<Car> getCars() {
        return cars;
    }
}
