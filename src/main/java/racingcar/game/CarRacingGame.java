package racingcar.game;


import racingcar.car.Car;
import racingcar.game.dto.RacingResult;
import racingcar.game.dto.WinnerResult;
import racingcar.move.Movement;
import racingcar.request.CarNameRequestInfo;
import racingcar.request.RoundNumberRequestInfo;
import racingcar.round.RacingRound;
import racingcar.view.CarNameInputView;
import racingcar.view.RacingResultOutView;
import racingcar.view.RoundNumberInputView;
import racingcar.view.WinnerOutView;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame implements Game {

    private final List<Car> cars;
    private final Movement movement;
    private RacingRound racingRound;
    private final GameWinner gameWinner;

    public CarRacingGame(Movement movement) {
        this.movement = movement;
        this.cars = new ArrayList<>();
        this.gameWinner = new GameWinner();

    }

    @Override
    public boolean ready() {
        boolean isReadyToCarName = false;
        while (!isReadyToCarName) {
            isReadyToCarName = readyInputCarName();
        }

        boolean isReadyToRoundNumber = false;
        while (!isReadyToRoundNumber) {
            isReadyToRoundNumber = readyInputRoundNumber();
        }
        return true;
    }

    @Override
    public void start() {
        while (racingRound.possibleRoundStart()) {
            List<RacingResult> racingResults = racingRound.start(cars, movement);
            RacingResultOutView.racingResult(racingResults);
        }
    }

    @Override
    public void finish() {
        List<WinnerResult> winners = gameWinner.selectWinner(cars);
        WinnerOutView.racingResult(winners);
    }

    private boolean readyInputCarName() {
        CarNameRequestInfo carNameRequestInfo = CarNameInputView.inputValue();
        try {
            for (String name : carNameRequestInfo.getCarNames()) {
                cars.add(new Car(name));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean readyInputRoundNumber() {
        RoundNumberRequestInfo roundNumberRequestInfo = RoundNumberInputView.inputValue();
        String round = roundNumberRequestInfo.getRound();
        try {
            this.racingRound = new RacingRound(round);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


}
