package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingCars {

    private static final StringBuilder stringBuilder = new StringBuilder();
    private final List<RacingCar> racingCars = new ArrayList<>();
    private final NumberGenerator numberGenerator;

    public RacingCars(List<String> names, NumberGenerator numberGenerator, MovingStrategy movingStrategy) {
        for (String name : names) {
            racingCars.add(new RacingCar(name, movingStrategy));
        }
        this.numberGenerator = numberGenerator;
    }

    public void moveCars() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(numberGenerator.pickNumber());
        }
    }

    public List<String> findWinners() {
        List<String> winnerNames = new ArrayList<>();
        RacingCar winningDistanceRacingCar = findWinningDistanceRacingCar();
        for (RacingCar racingCar : racingCars) {
            addIfWinningCar(winnerNames, winningDistanceRacingCar, racingCar);
        }
        return winnerNames;
    }

    private void addIfWinningCar(List<String> winnerNames, RacingCar winningDistanceRacingCar, RacingCar racingCar) {
        if (winningDistanceRacingCar.hasSameDistance(racingCar)) {
            winnerNames.add(racingCar.getRacingCarName());
        }
    }

    private RacingCar findWinningDistanceRacingCar() {
        racingCars.sort(Comparator.reverseOrder());
        return racingCars.get(0);
    }

    @Override
    public String toString() {
        stringBuilder.setLength(0);
        for (RacingCar racingCar : racingCars) {
            stringBuilder.append(racingCar.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
