package racinggame.domain;

import static racinggame.utils.RacingGameUtils.isValidRacingCarNameLengthLimit;

public class RacingCarName {
    private String racingCarName;

    public RacingCarName(String racingCarName) {
        validateRacingCarName(racingCarName);
        this.racingCarName = racingCarName;
    }

    public String getRacingCarName() {
        return racingCarName;
    }

    public void validateRacingCarName(String racingCarName) {
        isValidRacingCarNameLengthLimit(racingCarName);
    }
}
