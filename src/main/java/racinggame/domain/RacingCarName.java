package racinggame.domain;

import static racinggame.utils.RacingGameUtils.isValidRacingCarNameLengthLimit;

public class RacingCarName {
    private String racingCarName;

    public RacingCarName(String racingCarName) {
        validation(racingCarName);
        this.racingCarName = racingCarName;
    }

    public String getRacingCarName() {
        return racingCarName;
    }

    public void validation(String racingCarName) {
        isValidRacingCarNameLengthLimit(racingCarName);
    }
}
