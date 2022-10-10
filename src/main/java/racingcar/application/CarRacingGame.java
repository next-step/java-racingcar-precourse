package racingcar.application;

import racingcar.application.io.Input;
import racingcar.application.io.Output;
import racingcar.domain.car.CarRaceTrack;
import racingcar.domain.car.Cars;
import racingcar.domain.car.History;
import racingcar.domain.car.vo.Round;
import racingcar.domain.policy.MovePolicy;

public class CarRacingGame {

    private final Input input;
    private final Output output;
    private final MovePolicy movePolicy;

    public CarRacingGame(Input input, Output output, MovePolicy movePolicy) {
        this.input = input;
        this.output = output;
        this.movePolicy = movePolicy;
    }

    public void run() {
        Cars cars = createCars();
        Round round = createRound();

        CarRaceTrack track = new CarRaceTrack(movePolicy, cars, History.empty());
        result(track.round(round));
    }

    private void result(CarRaceTrack track) {
        output.printResult(track.history());
        output.printWinners(track.winners());
    }

    private Round createRound() {
        output.printRoundInput();
        Round round = null;
        do {
            round = inputRound(round);
        } while (round == null);

        return round;
    }

    private Cars createCars() {
        output.printCarNameInput();
        Cars cars = null;
        do {
            cars = inputCars(cars);
        } while (cars == null);

        return cars;
    }

    private Cars inputCars(Cars cars) {
        try {
            cars = Cars.from(input.carNameInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        return cars;
    }

    private Round inputRound(Round round) {
        try {
            round = new Round(input.round());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        return round;
    }
}
