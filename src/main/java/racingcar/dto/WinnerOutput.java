package racingcar.dto;

import racingcar.domain.RacingCar;

import java.util.List;

public class WinnerOutput {

    private static final String LAST_DELIMITER_REGEX = ".$";
    private static final String EMPTY_STRING = "";
    private static final String WINNERS_DELIMITER = ",";

    private final String winners;

    public WinnerOutput(final List<RacingCar> winners) {
        final StringBuilder winnersBuilder = new StringBuilder();
        for (RacingCar winner : winners) {
            winnersBuilder.append(winner.getName());
            winnersBuilder.append(WINNERS_DELIMITER);
        }
        this.winners = winnersBuilder.toString().replaceAll(LAST_DELIMITER_REGEX, EMPTY_STRING);
    }

    public String getWinners() {
        return winners;
    }
}
