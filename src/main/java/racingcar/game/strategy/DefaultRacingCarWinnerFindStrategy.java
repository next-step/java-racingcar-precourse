package racingcar.game.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.car.RacingCar;
import racingcar.car.RacingCarName;
import racingcar.car.RacingCars;

public class DefaultRacingCarWinnerFindStrategy implements RacingCarWinnerFindStrategy {
    private List<RacingCarName> winners = new ArrayList<>();
    private int maxPosition = Integer.MIN_VALUE;

    @Override
    public List<RacingCarName> pickWinners(RacingCars racingCars) {
        List<RacingCar> racingCarList = racingCars.getRacingCarList();
        findMaxPosition(racingCarList);
        for (RacingCar car : racingCarList) {
            addWinner(car);
        }
        return Collections.unmodifiableList(winners);
    }

    private void findMaxPosition(List<RacingCar> racingCarList) {
        List<Integer> positions = new ArrayList<>();
        for (RacingCar car : racingCarList) {
            positions.add(car.getRacingCarPosition().getPosition());
        }
        maxPosition = Collections.max(positions);
    }

    private void addWinner(RacingCar car) {
        if (car.getRacingCarPosition().getPosition() == maxPosition) {
            winners.add(car.getRacingCarName());
        }
    }
}
