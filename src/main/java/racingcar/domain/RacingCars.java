package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public int size() {
        return this.racingCars.size();
    }

    public RacingCar get(int i) {
        return this.racingCars.get(i);
    }

    public void raceAll() {
        for (RacingCar racingCar : racingCars) {
            racingCar.race();
        }
    }

    public void printRacingCarsState() {
        for (RacingCar racingCar : racingCars) {
            System.out.printf("%s : %s", racingCar.getName(), makeDistanceIndicator(racingCar));
            System.out.println();
        }
        System.out.println();
    }

    private String makeDistanceIndicator(final RacingCar racingCar) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < racingCar.getDistance(); i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    public RacingCars getWinners() {
        final List<RacingCar> racingCarList = new ArrayList<>();
        final Integer maxDistance = getMaxDistance();
        for (final RacingCar racingCar : racingCars) {
            addToListIfEqualToMaxDistance(racingCarList, racingCar, maxDistance);
        }
        return new RacingCars(racingCarList);
    }

    private Integer getMaxDistance() {
        final Set<Integer> distanceSet = new HashSet<>();
        for (RacingCar racingCar : racingCars) {
            distanceSet.add(racingCar.getDistance());
        }
        return Collections.max(distanceSet);
    }

    private void addToListIfEqualToMaxDistance(final List<RacingCar> racingCars, final RacingCar racingCar,
                                               final Integer maxDistance) {
        if (racingCar.getDistance().equals(maxDistance)) {
            racingCars.add(racingCar);
        }
    }
}
