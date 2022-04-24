package racingcar.impl;

import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;
import racingcar.domain.race.RaceTime;
import racingcar.service.RacingService;
import racingcar.view.OutputView;

public class RacingServiceImpl implements RacingService {
    private final Cars cars;
    private final RaceTime raceTime;
    private OutputView outputView;

    public RacingServiceImpl(Cars cars, RaceTime raceTime) {
        this.cars = cars;
        this.raceTime = raceTime;
        this.outputView = new OutputView();
    }

    @Override
    public void start() {
        outputView.resultPrint();

        int index = 0;

        while (!raceTime.isLast(index)){

            racing();
            racePrint();
            index++;
        }
        raceWinner();
    }

    @Override
    public void racing() {
        for (Car car : cars.getCars()) {
            car.move();
        }
    }

    @Override
    public void racePrint() {

        for (Car car : cars.getCars()) {
            outputView.raceRoundResult(car);
        }

    }

    @Override
    public void raceWinner() {
        outputView.printWinner(cars.getWinner());
    }
}
