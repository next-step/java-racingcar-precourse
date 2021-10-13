package racinggame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingCarGame {
    private final List<RacingCar> racingCars;
    private int maxPosition;
    private Map<RacingCar, List<Integer>> racingCarStepByPosition;

    public RacingCarGame(List<RacingCar> racingCars, int moveTryCount) {
        this.racingCars = racingCars;
        configurateRacingGame();
        moveForwardRacingCars(moveTryCount);
    }

    private void configurateRacingGame() {
        this.racingCarStepByPosition = new LinkedHashMap<>();
        this.racingCars.forEach(racingCar -> this.racingCarStepByPosition.put(racingCar, new ArrayList<>()));
    }

    private void moveForwardRacingCars(int moveTryCount) {
        for (int i = 0; i < moveTryCount; i++) {
            moveRacingCars();
        }
        verifyMaxPosition();
    }

    private void moveRacingCars() {
        this.racingCarStepByPosition.forEach((racingCar, stepByPosition) -> stepByPosition.add(racingCar.moveForwardRacingCar()));
    }

    private void verifyMaxPosition() {
        this.racingCars.forEach(racingCar -> findMaxPosition(racingCar));
    }

    private void findMaxPosition(RacingCar racingCar) {
        this.maxPosition = maxPosition > racingCar.getRacingCarPosition() ? maxPosition : racingCar.getRacingCarPosition();
    }

    public Map<RacingCar, List<Integer>> getRacingCarStepByPosition() {
        return Collections.unmodifiableMap(this.racingCarStepByPosition);
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        this.racingCars.forEach(racingCar -> addWinner(winners, racingCar));
        return winners;
    }

    private void addWinner(List<String> winners, RacingCar racingCar) {
        if (racingCar.getRacingCarPosition() == this.maxPosition) {
            winners.add(racingCar.getRacingCarName());
        }
    }
}
