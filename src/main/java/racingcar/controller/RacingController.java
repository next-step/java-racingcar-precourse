package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.vo.InputNumber;
import racingcar.service.RacingService;
import racingcar.service.impl.RacingServiceImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private RacingService racingService;
    private InputView inputView;
    private OutputView outputView;

    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void raceRun() {
        try {
            racingService = new RacingServiceImpl(inputCarName(), inputNumber());
            racingService.start();
        } catch (IllegalArgumentException e) {
            outputView.outputError(e);
            raceRun();
        }
    }

    public Cars inputCarName() {
        try {
            return new Cars(inputView.inputCarName());
        } catch (IllegalArgumentException e) {
            outputView.outputError(e);
            return inputCarName();
        }
    }

    public InputNumber inputNumber() {
        try {
            return new InputNumber(inputView.inputRacingCount());
        } catch (IllegalArgumentException e) {
            outputView.outputError(e);
            return inputNumber();
        }
    }
}
