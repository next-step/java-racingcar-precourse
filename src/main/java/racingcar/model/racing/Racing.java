package racingcar.model.racing;

import racingcar.model.car.CarDto;
import racingcar.model.car.Entries;

import java.util.List;

public class Racing {
    private final Entries entries;
    private final LapCount lapCount;

    Racing(Entries entries, LapCount lapCount) {
        this.entries = entries;
        this.lapCount = lapCount;
    }

    public static RacingBuilder builder() {
        return new RacingBuilder();
    }

    public RacingResult start(RacingStrategy racingStrategy) {
        for (int i = 0; i < lapCount.getLapCount(); i++) {
            entries.race(racingStrategy);
        }

        return makeResult();
    }

    private RacingResult makeResult() {
        List<CarDto> carDtoList = entries.convertCarDto();

        return new RacingResult(carDtoList, lapCount);
    }
}
