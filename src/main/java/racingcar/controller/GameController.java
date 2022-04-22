package racingcar.controller;

import racingcar.constant.ErrorMessage;
import racingcar.model.car.CarConfig;
import racingcar.model.lap.LapConfig;
import racingcar.model.racing.Racing;
import racingcar.model.racing.RacingBuilder;
import racingcar.model.movement.MovementStrategy;
import racingcar.model.record.RacingRecord;
import racingcar.view.GameInput;
import racingcar.view.GameOutput;

public class GameController {
    private final MovementStrategy movementStrategy;
    private final GameInput input;
    private final GameOutput output;

    public GameController(MovementStrategy movementStrategy, GameInput input, GameOutput output) {
        this.movementStrategy = movementStrategy;
        this.input = input;
        this.output = output;
    }

    public void start() {
        RacingBuilder builder = Racing.builder();
        setCarNames(builder);
        setLapCount(builder);
        Racing racing = builder.build();

        RacingRecord racingRecord = racing.start(movementStrategy);
        showResult(racingRecord);
    }

    private void setCarNames(RacingBuilder builder) {
        try {
            output.inputCarNames();
            String carNames = input.read();
            builder.carNames(carNames);
        } catch (IllegalArgumentException e) {
            output.error(String.format(ErrorMessage.INVALID_CAR_NAMES_LENGTH, CarConfig.MIN_CAR_NAME_LENGTH,
                                       CarConfig.MAX_CAR_NAME_LENGTH));
            setCarNames(builder);
        }
    }

    private void setLapCount(RacingBuilder builder) {
        try {
            output.inputLapCount();
            String lapCount = input.read();
            builder.lapCount(lapCount);
        } catch (IllegalArgumentException e) {
            output.error(String.format(ErrorMessage.INVALID_CAR_RACING_COUNT_RANGE, LapConfig.MIN_LAP_COUNT,
                                       LapConfig.MAX_LAP_COUNT));
            setLapCount(builder);
        }
    }

    private void showResult(RacingRecord racingRecord) {
        output.showRacingRecord(racingRecord);
        output.showChampions(racingRecord.getChampionNames());
    }
}
