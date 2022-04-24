package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import org.assertj.core.util.VisibleForTesting;
import racingcar.model.CarName;
import racingcar.model.Position;

public class RacingCars {
    @VisibleForTesting
    ArrayList<RacingCar> cars = new ArrayList<>();
    ArrayList<CarName> winners = new ArrayList<>();

    public RacingCars(ArrayList<RacingCar> cars) {
        this.cars.addAll(cars);
    }

    public void playRound() {
        cars.forEach(car -> car.move(RandomUtils.getRandomNumber()));
    }

    public String getWinners() {
        Position winnerPosition = getMaxPosition();
        for (RacingCar car : cars) {
            addWinner(car, winnerPosition);
        }
        return getWinnerOutPutResult();
    }

    private void addWinner(RacingCar car, Position winnerPosition) {
        if (car.isWinner(winnerPosition)) {
            winners.add(car.getName());
        }
    }

    private Position getMaxPosition() {
        List<Integer> positions = new ArrayList<>();
        for (RacingCar racingCar : cars) {
            positions.add(racingCar.getGamePosition().getPosition());
        }
        return new Position(Collections.max(positions));
    }

    private String getWinnerOutPutResult() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (CarName winner : winners) {
            stringJoiner.add(winner.getName());
        }
        return stringJoiner.toString();
    }
}
