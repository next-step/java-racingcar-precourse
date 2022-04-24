package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import org.assertj.core.util.VisibleForTesting;

public class RacingCars {
    @VisibleForTesting
    ArrayList<RacingCar> cars = new ArrayList<>();
    ArrayList<String> winners = new ArrayList<>();

    public RacingCars(ArrayList<RacingCar> cars) {
        this.cars.addAll(cars);
    }

    public void playRound() {
        cars.forEach(car -> car.move(RandomUtils.getRandomNumber()));
    }

    public String getWinners() {
        int winnerPosition = getMaxPosition();
        for (RacingCar car : cars) {
            addWinner(car, winnerPosition);
        }
        return getWinnerOutPutResult();
    }

    private void addWinner(RacingCar car, int winnerPosition) {
        if (car.isWinner(winnerPosition)) {
            winners.add(car.getName());
        }
    }

    private int getMaxPosition() {
        List<Integer> positions = new ArrayList<>();
        for (RacingCar racingCar : cars) {
            positions.add(racingCar.getGamePosition());
        }
        return Collections.max(positions);
    }

    private String getWinnerOutPutResult() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (String winner : winners) {
            stringJoiner.add(winner);
        }
        return stringJoiner.toString();
    }
}
