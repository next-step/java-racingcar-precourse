package racinggame.domain;

import java.util.*;

public class RacingGame {

    private final Cars cars;

    private RacingGame(Cars cars) {
        this.cars = cars;
    }

    public static RacingGame from(String names) {
        return new RacingGame(nameStringToCars(names));
    }

    private static Cars nameStringToCars(String input) {
        CarNames names = CarNames.from(input);
        List<Car> cars = new ArrayList<>(names.size());
        for (int i = 0; i < names.size(); i++) {
            cars.add(Car.from(names.get(i)));
        }
        return new Cars(cars);
    }

    public RacingResult startNTimes(TryTimes n) {
        RacingResult racingResult = new RacingResult();
        for (int i = 0; i < n.getValue(); i++) {
            raceOneTime();
            racingResult.record(cars);
        }
        racingResult.addWinners(findWinners());
        return racingResult;
    }

    private Cars findWinners() {
        Map<Integer, List<Car>> scoreMap = makeScoreMap(cars);
        int highestScore = findHighestScore(cars);
        return new Cars(scoreMap.get(highestScore));
    }

    private Map<Integer, List<Car>> makeScoreMap(Cars cars) {
        Map<Integer, List<Car>> scoreMap = new HashMap<>(cars.size());
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            scoreMap.put(
                    car.getLocation().getLocationValue(),
                    putCarWithNewListIfNull(scoreMap.get(car.getLocation().getLocationValue()), car)
            );
        }
        return scoreMap;
    }

    private int findHighestScore(Cars cars) {
        int high = 0;
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            high = Math.max(car.getLocation().getLocationValue(), high);
        }
        return high;
    }

    private List<Car> putCarWithNewListIfNull(List<Car> list, Car car) {
        if (Objects.isNull(list)) {
            list = new ArrayList<>();
        }
        list.add(car);
        return list;
    }

    private void raceOneTime() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).moveForwardBy(SeedForMove.random());
        }
    }

    public int getCarCount() {
        return this.cars.size();
    }
}
