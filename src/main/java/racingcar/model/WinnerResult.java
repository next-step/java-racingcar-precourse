package racingcar.model;

import java.util.StringJoiner;

public class WinnerResult {
    Winners winners;
    private final String printWinners;

    public WinnerResult(Winners winners) {
        this.winners = winners;
        this.printWinners = setPrintWinners();
    }

    private String setPrintWinners() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (CarName winner : winners.getWinners()) {
            stringJoiner.add(winner.getName());
        }
        return stringJoiner.toString();
    }

    public String getPrintWinners() {
        return printWinners;
    }
}
