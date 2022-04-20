package racingcar.service;

import racingcar.domain.Cars;

import java.util.List;

public class RacingService {

    private Cars cars = new Cars();

    public String play(List<String> names, int round) {
        cars.lineUpCars(names);
        System.out.println("실행 결과");
        while (round-- > 0) {
            cars.processRound();
            System.out.println(cars);
        }
        return cars.findWinners();
    }
}
