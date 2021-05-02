package controller;

import constant.SystemMessage;
import domain.Car;
import domain.Count;
import domain.Race;
import domain.RaceReport;
import dto.CarDto;
import util.RaceReportFormatUtil;
import ui.Input;
import ui.Output;

public class CarRaceController {
    public static void main(String[] args) {
        Output.print(SystemMessage.CAR_NAMES_REQUEST_MESSAGE);
        Race race = Race.create(Input.requestString());
        Output.print(SystemMessage.MOVE_COUNT_REQUEST_MESSAGE);
        Count raceCount = new Count(Input.requestInt());
        playRaceOfCount(raceCount, race);
        Output.print(RaceReportFormatUtil.formatWinners(race.createReport()) + SystemMessage.WINNER_REPORT);
    }

    private static void playRaceOfCount(Count count, Race race) {
        for (int i = 0; i < count.getCount(); i++) {
            Output.print(RaceReportFormatUtil.format(race.play()));
        }
    }

}
