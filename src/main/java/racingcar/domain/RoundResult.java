package racingcar.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoundResult {

    private final int roundNum;

    @Getter
    private final RacingCars racingCars;

    @Override
    public String toString() {
        return racingCars + "\n";
    }
}
