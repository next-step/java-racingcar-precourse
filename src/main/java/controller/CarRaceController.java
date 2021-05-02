package controller;

import constant.SystemMessage;
import domain.Count;
import domain.Race;
import domain.RaceReport;
import util.RaceReportFormatUtil;
import ui.Input;
import ui.Output;

public class CarRaceController {
    public static void main(String[] args) {
        Output.print(SystemMessage.CAR_NAMES_REQUEST_MESSAGE);
        String carNames = Input.requestString();
        Output.print(SystemMessage.MOVE_COUNT_REQUEST_MESSAGE);
        Count raceCount = new Count(Input.requestInt());
        Race race = Race.create(carNames, raceCount);
        playRaceUntilEnd(race);
    }

    private static void playRaceUntilEnd(Race race) {
        do {
            printReport(race.playOneCount());
        } while (!race.isEnd());
    }

    private static void printReport(RaceReport raceReport) {
        Output.print(RaceReportFormatUtil.format(raceReport));
    }

}
