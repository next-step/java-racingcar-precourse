package racingcar.controller;

import racingcar.constant.ErrorMessage;
import racingcar.model.car.CarConfig;
import racingcar.model.racing.Racing;
import racingcar.model.racing.RacingBuilder;
import racingcar.model.racing.RacingStrategy;
import racingcar.model.record.RacingRecord;
import racingcar.view.GameInput;
import racingcar.view.GameOutput;

public class GameController {
    private final RacingStrategy racingStrategy;
    private final GameInput input;
    private final GameOutput output;

    public GameController(RacingStrategy racingStrategy, GameInput input, GameOutput output) {
        this.racingStrategy = racingStrategy;
        this.input = input;
        this.output = output;
    }

    public void start() {
        RacingBuilder builder = Racing.builder();
        setCarNames(builder);
        setLapCount(builder);
        Racing racing = builder.build();

        RacingRecord racingRecord = racing.start(racingStrategy);
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
            output.error(String.format(ErrorMessage.INVALID_CAR_RACING_COUNT_RANGE, CarConfig.MIN_LAP_COUNT,
                                       CarConfig.MAX_LAP_COUNT));
            setLapCount(builder);
        }
    }

    private void showResult(RacingRecord racingRecord) {
        output.showRacingRecord(racingRecord);
        output.showChampions(racingRecord.getChampionNames());
    }
}
