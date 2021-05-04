package dev.heowc.car;

import java.util.*;

public final class WinnerGroup {

    private final List<RacingCar> racingCars;

    public static WinnerGroup create(RacingCarGroup group) {
        final List<RacingCar> cars = group.cars();
        final Map<Integer, List<RacingCar>> racingCarMap = new HashMap<>(cars.size());
        int maxPosition = RacingCar.INIT_COUNT;
        for (RacingCar car : cars) {
            racingCarMap.computeIfAbsent(car.getPosition(), position -> new ArrayList<>()).add(car);
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return new WinnerGroup(racingCarMap.get(maxPosition));
    }

    private WinnerGroup(List<RacingCar> racingCars) {
        this.racingCars = Collections.unmodifiableList(racingCars);
    }

    public String names() {
        final StringJoiner joiner = new StringJoiner(", ");
        for (RacingCar car : racingCars) {
            joiner.add(car.getName());
        }
        return joiner.toString();
    }
}
