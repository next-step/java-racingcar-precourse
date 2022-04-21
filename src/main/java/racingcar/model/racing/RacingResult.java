package racingcar.model.racing;

import racingcar.model.car.CarDto;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    private final List<CarDto> cars;
    private final LapCount lapCount;

    public RacingResult(List<CarDto> cars, LapCount lapCount) {
        this.cars = cars;
        this.lapCount = lapCount;
    }

    public int getLapCount() {
        return lapCount.getLapCount();
    }

    public List<String> getChampionNames() {
        List<String> champions  = new ArrayList<>();
        for (CarDto car : cars) {
            addChampion(champions, car);
        }
        return champions;
    }

    private void addChampion(List<String> champions, CarDto car) {
        if (car.isChampion()) {
            champions.add(car.getName());
        }
    }
}
