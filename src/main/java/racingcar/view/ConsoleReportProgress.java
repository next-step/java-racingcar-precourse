package racingcar.view;

import racingcar.model.progress.CarMoveScores;
import racingcar.model.progress.MoveScore;
import racingcar.model.progress.RaceScore;

public class ConsoleReportProgress {
    public static final PrintMessage TITLE = PrintMessage.of("\n실행 결과\n");
    public static final PrintMessage MOVE_SCORE_UNIT = PrintMessage.of("-");
    public static final PrintMessage LAPS_SEPARATOR = PrintMessage.of("\n");

    public static void printRaceScore(RaceScore raceScore) {
        for (CarMoveScores carMoveScores : raceScore.get()) {
            ConsoleReportProgress.print(
                    PrintMessage.of(ConsoleReportProgress.getPrintableCarMoveScores(carMoveScores) + "\n"));
        }
        ConsoleReportProgress.printLapsSeparator();
    }

    private static String getPrintableCarMoveScores(CarMoveScores carMoveScores) {
        String title = carMoveScores.getTitle().get();
        MoveScore moveScore = carMoveScores.getMoveScores().get();
        return String.format("%s : %s", title, ConsoleReportProgress.getPrintableMoveScore(moveScore));
    }

    private static String getPrintableMoveScore(MoveScore moveScore) {
        StringBuilder printableMoveScore = new StringBuilder();
        for (int i = 0; i < moveScore.get(); i++) {
            printableMoveScore.append(ConsoleReportProgress.MOVE_SCORE_UNIT);
        }
        return printableMoveScore.toString();
    }

    public static void printTitle() {
        ConsoleReportProgress.print(ConsoleReportProgress.TITLE);
    }

    private static void printLapsSeparator() {
        ConsoleReportProgress.print(ConsoleReportProgress.LAPS_SEPARATOR);
    }

    private static void print(PrintMessage printMessage) {
        System.out.print(printMessage.toString());
    }
}
