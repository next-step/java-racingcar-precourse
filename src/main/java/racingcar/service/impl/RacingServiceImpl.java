package racingcar.service.impl;

import racingcar.model.Cars;
import racingcar.model.vo.Car;
import racingcar.model.vo.InputNumber;
import racingcar.model.vo.RandomNumber;
import racingcar.service.RacingService;
import racingcar.view.OutputView;

public class RacingServiceImpl implements RacingService {

    private final Cars cars;
    private final InputNumber inputNumber;
    private OutputView outputView;

    public RacingServiceImpl(Cars cars, InputNumber inputNumber) {
        this.cars = cars;
        this.inputNumber = inputNumber;
        this.outputView = new OutputView();
    }

    @Override
    public void start() {
        racing();
        raceResult();
        winner();
    }

    @Override
    public void racing() {
        for (Car car : cars.toList()) {
            car.carMove(inputNumber.getGameCount());
        }
    }

    @Override
    public void raceResult() {
        outputView.outputResult();
        for (Car car : cars.toList()) {
            outputView.outputResultCar(car);
        }
    }

    @Override
    public void winner() {
        outputView.outputEndGame(String.join(",",cars.winnerName(cars.isMaxPosition())));
    }
}
