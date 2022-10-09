package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.progress.CarMoveScores;
import racingcar.model.progress.RaceScore;

public class ConsoleReportWinner {
    public static final PrintMessage TITLE = PrintMessage.of("최종 우승자 : ");
    public static final PrintMessage WINNER_SEPARATOR = PrintMessage.of(", ");

    public static void printWinner(RaceScore raceScore) {
        ConsoleReportWinner.print(PrintMessage.of(
                ConsoleReportWinner.TITLE + ConsoleReportWinner.getWinnerMessage(raceScore).toString()));
    }

    private static PrintMessage getWinnerMessage(RaceScore raceScore) {
        return PrintMessage.of(String.join(ConsoleReportWinner.WINNER_SEPARATOR.toString(),
                ConsoleReportWinner.getWinnerTitles(raceScore)));
    }

    private static List<String> getWinnerTitles(RaceScore raceScore) {
        List<String> winners = new ArrayList<>();
        for (CarMoveScores carMoveScores : raceScore.get()) {
            winners.add(carMoveScores.getTitle().get());
        }
        return winners;
    }

    private static void print(PrintMessage printMessage) {
        System.out.print(printMessage.toString());
    }
}
