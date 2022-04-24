package racingcar.model;

import java.util.ArrayList;
import java.util.StringJoiner;

public class WinnerResult {
    ArrayList<CarName> winners = new ArrayList<>();
    private final String printWinners;

    public WinnerResult(ArrayList<CarName> winners) {
        this.winners.addAll(winners);
        this.printWinners = setPrintWinners();
    }

    private String setPrintWinners() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (CarName winner : winners) {
            stringJoiner.add(winner.getName());
        }
        return stringJoiner.toString();
    }

    public String getPrintWinners() {
        return printWinners;
    }
}
