package racingcar.domain;

import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.GameConfig.NAME_SEPARATOR;

public class Race {

    private final Cars cars;
    private int round;
    private int mostMoveCount;

    public Race(final Cars cars,final int round) {
        this.cars = cars;
        this.round = round;
        this.mostMoveCount = 0;
    }

    public void start() {
        mostMoveCount = cars.move(RandomUtils.randomNumbers(cars.size()));
    }

    public String roundWinnersName() {
        List<Car> winners = roundWinners();
        List<String> winnersName = new ArrayList<>();
        for (Car car : winners) {
            winnersName.add(car.getName());
        }
        return String.join(NAME_SEPARATOR, winnersName);
    }

    private List<Car> roundWinners() {
        return cars.winners(mostMoveCount);
    }



}
