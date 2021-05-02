package racingcar;

import utils.RandomValueGenerator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RacingCars {
    private final Set<RacingCar> racingCars;

    public RacingCars(Set<Name> names) {
        this.racingCars = new LinkedHashSet<>();
        for (Name name : names)
            racingCars.add(new RacingCar(name));
    }

    public void moveForward() {
        racingCars.forEach(racingCar -> racingCar.moveForward(RandomValueGenerator.generate()));
    }

    public Set<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<String> getWinners() {
        int max = getMax();

        List<String> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars)
            addWinners(winners, racingCar, max);

        return winners;
    }

    private void addWinners(List<String> winners, RacingCar racingCar, int max) {
        if (isWinner(racingCar, max))
            winners.add(racingCar.getName());
    }

    private boolean isWinner(RacingCar racingCar, int max) {
        return racingCar.getDistance() == max;
    }

    private int getMax() {
        int max = 0;
        for (RacingCar racingCar : racingCars)
            max = Math.max(racingCar.getDistance(), max);
        return max;
    }
}
