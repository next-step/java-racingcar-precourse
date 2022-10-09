package view;

import controller.RacingController;
import domain.CarNames;
import domain.Laps;
import domain.RaceResult;

public class OutputView {

    public static final String MESSAGE_INFO_RACE_RESULT = "실행 결과";
    public static final String MESSAGE_INFO_WINNERS = "최종 우승자 : ";

    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public static void broadcastRace(CarNames carNames, Laps laps, int lap) {
        System.out.println(MESSAGE_INFO_RACE_RESULT);
        while (lap < laps.getLaps()) {
            RacingController.progressRace(carNames);
            lap++;
            System.out.println();
        }
    }

    public static void announceWinner(RaceResult raceResult) {
        System.out.print(MESSAGE_INFO_WINNERS);
        System.out.println(raceResult.getWinners());
    }
}
