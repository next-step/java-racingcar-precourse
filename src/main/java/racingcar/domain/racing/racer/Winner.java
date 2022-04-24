package racingcar.domain.racing.racer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import racingcar.domain.racing.car.Car;
import racingcar.domain.racing.car.Cars;

public class Winner {
    private final Cars winners;

    private Winner(List<Car> allParticipants) {
        winners = Cars.from(findWinners(allParticipants));
    }

    public static Winner find(List<Car> allParticipants) {
        return new Winner(allParticipants);
    }

    public List<Car> getWinners() {
        return winners.getCarList();
    }

    private List<Car> findWinners(List<Car> allParticipants) {
        int locationOfWinner = findLocationOfWinner(allParticipants);

        List<Car> winnerList = new ArrayList<>();
        for (Car car : allParticipants) {
            checkIfWinner(car, locationOfWinner).ifPresent(winnerList::add);
        }
        return winnerList;
    }

    private int findLocationOfWinner(List<Car> allParticipants) {
        return Collections.max(allParticipants, Comparator.comparingInt(Car::getLocation))
                .getLocation();
    }

    private Optional<Car> checkIfWinner(Car car, int locationOfWinner) {
        return locationOfWinner == car.getLocation() ? Optional.of(car) : Optional.empty();
    }
}
