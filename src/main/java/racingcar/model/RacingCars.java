package racingcar.model;

import racingcar.exception.InvalidUserCountException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RacingCars implements Iterable<RacingCar> {

    private static final String NAME_SPLIT_REGEX = ",";
    private final List<RacingCar> cars;

    private RacingCars() {
        this.cars = new LinkedList<>();
    }

    public static RacingCars createRacingCarsFromInput(String input) {
        validateName(input);
        String[] names = input.split(NAME_SPLIT_REGEX);

        RacingCars racingCars = new RacingCars();

        for (String name : names) {
            racingCars.cars.add(RacingCar.createRacingCarWithDefaultStrategy(name));
        }

        return racingCars;
    }

    private static void validateName(String name) {
        String[] names = name.split(NAME_SPLIT_REGEX);
        if (names.length < 2) {
            throw new InvalidUserCountException();
        }
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    @Override
    public Iterator<RacingCar> iterator() {
        return cars.iterator();
    }

    public int getMaxDistance() {
        int max = 0;

        for (RacingCar racingCar : cars) {
            int distance = racingCar.getDistance();
            max = Math.max(distance, max);
        }

        return max;
    }
}
