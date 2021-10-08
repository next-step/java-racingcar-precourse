package racinggame.model;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private static final String SPLIT_REGEX = ",";

    private final Cars cars;
    private TryCount count;

    public RacingGame(String inputNames) {
        this.cars = constructCars(inputNames);
    }

    private Cars constructCars(String inputNames) {
        String[] split = inputNames.split(SPLIT_REGEX);
        List<String> names = Arrays.asList(split);
        return new Cars(names);
    }

    public void setCount(int count) {
        this.count = new TryCount(count);
    }

    public boolean isPlaying() {
        return count != null && count.canPlaying();
    }

    public MoveResults moveOnce(List<Integer> randomNumbers) {
        cars.moveAll(randomNumbers);
        count.decrease();
        return cars.getResult();
    }

    public String getWinners() {
        List<String> winners = cars.getWinners();
        return String.join(SPLIT_REGEX, winners);
    }

    public int getNumberOfCars() {
        return cars.size();
    }
}
