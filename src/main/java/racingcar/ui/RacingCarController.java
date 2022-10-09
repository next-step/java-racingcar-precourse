package racingcar.ui;

import racingcar.domain.*;
import racingcar.dto.RecordDto;

import java.util.Optional;

public class RacingCarController {
    private final Movement movement = NumberConditionMovement.from(RandomNumberGenerator.instance());

    public void start() {
        Racing racing = Racing.of(createEntry(), createLap());
        RecordDto recordDto = racing.race(movement);
        OutputView.showRecord(recordDto);
    }

    private Entry createEntry() {
        Optional<Entry> entry;
        do {
            entry = inputCarNames();
        } while (!entry.isPresent());
        return entry.get();
    }

    private Optional<Entry> inputCarNames() {
        try {
            String carNames = InputView.inputCarNames();
            return Optional.of(Entry.from(carNames));
        } catch(IllegalArgumentException e) {
            OutputView.error(e.getMessage());
            return Optional.empty();
        }
    }

    private Lap createLap() {
        Optional<Lap> lap;
        do {
            lap = inputLap();
        } while (!lap.isPresent());
        return lap.get();
    }

    private Optional<Lap> inputLap() {
        try {
            String lapCount = InputView.inputLapCount();
            return Optional.of(Lap.from(lapCount));
        } catch(IllegalArgumentException e) {
            OutputView.error(e.getMessage());
            return Optional.empty();
        }
    }
}
