package racingcar.controller;

import racingcar.domain.dto.PlayHistories;
import racingcar.domain.model.Cars;
import racingcar.domain.model.Round;
import racingcar.service.RacingGameService;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameOutputView;

import java.util.List;

public class RacingGameControllerImpl implements RacingGameController {

    private final RacingGameInputView inputView;
    private final RacingGameOutputView outputView;
    private final RacingGameService service;

    public RacingGameControllerImpl(RacingGameInputView inputView, RacingGameOutputView outputView, RacingGameService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    @Override
    public void start() {
        final Cars cars = readyToCars();
        final Round round = readyToRound();

        List<PlayHistories> totalPlayHistories = service.play(cars, round);

        outputView.outputTotalPlayHistories(totalPlayHistories);
        outputView.outputWinner(cars.getWinnersCarNames());
    }

    private Cars readyToCars() {
        while (true) {
            try {
                String carNames = inputView.inputCarNames();
                return service.readyToCars(carNames);
            } catch (IllegalArgumentException exception) {
                outputView.outputErrorMessage(exception.getMessage());
            }
        }
    }

    private Round readyToRound() {
        while (true) {
            try {
                String round = inputView.inputRound();
                return service.readyToRound(round);
            } catch (IllegalArgumentException exception) {
                outputView.outputErrorMessage(exception.getMessage());
            }
        }
    }
}