package racingcar.dto;

import racingcar.domain.RacingCar;

import java.util.List;

public class RaceResultOutput {

    private static final String NAME_AND_POSITION_DELIMITER = " : ";
    private static final String NEW_LINE = "\n";
    private static final String POSITION_UNIT = "-";

    private final String raceResult;

    public RaceResultOutput(final List<RacingCar> racingCarList) {
        final StringBuilder raceResult = new StringBuilder();
        for (RacingCar racingCar : racingCarList) {
            raceResult.append(racingCar.getName());
            raceResult.append(NAME_AND_POSITION_DELIMITER);
            raceResult.append(renderPosition(racingCar));
            raceResult.append(NEW_LINE);
        }
        this.raceResult = raceResult.toString();
    }

    private String renderPosition(final RacingCar racingCar) {
        final StringBuilder position = new StringBuilder();
        for (int count = 0; count < racingCar.getPosition(); ++count) {
            position.append(POSITION_UNIT);
        }
        return position.toString();
    }

    public String getRaceResult() {
        return raceResult;
    }
}
