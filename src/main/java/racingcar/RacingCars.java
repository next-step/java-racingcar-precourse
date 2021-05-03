package racingcar;

import utils.RandomValueGenerator;

import java.util.*;

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
        int maxTravelDistance = getMaxTravelDistance();

        List<String> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars)
            addWinners(winners, racingCar, maxTravelDistance);

        return winners;
    }

    private void addWinners(List<String> winners, RacingCar racingCar, int maxTravelDistance) {
        if (Objects.equals(racingCar.getTravelDistance(), maxTravelDistance))
            winners.add(racingCar.getName());
    }

    private int getMaxTravelDistance() {
        int maxTravelDistance = 0;
        for (RacingCar racingCar : racingCars)
            maxTravelDistance = Math.max(racingCar.getTravelDistance(), maxTravelDistance);
        return maxTravelDistance;
    }
}
