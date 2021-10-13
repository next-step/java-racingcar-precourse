package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racinggame.utils.RacingGameUtils.racingCarNameSplit;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(final String racingCarNameInput) {
        this.racingCars = getRacingCarList(racingCarNameInput);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<RacingCar> getRacingCarList(final String racingCarNameInput) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String racingCarName : racingCarNameSplit(racingCarNameInput)) {
            racingCarList.add(new RacingCar(racingCarName));
        }
        return racingCarList;
    }

    public int getMaxMovesCount() {
        List<Integer> movesCounts = new ArrayList<>();
        racingCars.forEach(racingCar -> movesCounts.add(racingCar.getMovesCount()));

        return Collections.max(movesCounts);
    }

    public List<RacingCar> getWinners() {
        int maxMovesCount = getMaxMovesCount();
        List<RacingCar> winners = new ArrayList<>();

        racingCars.forEach(racingCar -> {
            isWinner(maxMovesCount, racingCar, winners);
        });
        return winners;
    }

    private void isWinner(int maxMovesCount, RacingCar racingCar, List<RacingCar> winners) {
        if (maxMovesCount == racingCar.getMovesCount()) {
            winners.add(racingCar);
        }
    }
}
