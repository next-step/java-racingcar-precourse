package racingcar.view;

import racingcar.message.GameMessage;
import racingcar.model.RaceWinners;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarCenter;
import racingcar.utils.MessageUtils;

import java.util.List;

public class GameWriter {

    public static void inquireCarNames() {
        System.out.println(GameMessage.NAMES_REQUIRE_MESSAGE);
    }

    public static void inquireRounds() {
        System.out.println(GameMessage.ROUNDS_REQUIRE_MESSAGE);
    }

    public static void writeError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void writeInfoBeforeRoundStart() {
        System.out.println(GameMessage.INFO_MESSAGE_BEFORE_RODUN_START);
    }

    public static void writeRoundResult(RacingCarCenter racingCarCenter) {
        for (RacingCar racingCar : racingCarCenter.getRacingCars()) {
            System.out.println(racingCar.getName() + " : " + MessageUtils.replcaePositionToSpecialCharacter(racingCar, "-"));
        }
        System.out.println();
    }

    public static void writeRaceResult(RaceWinners raceWinners) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자 : ");
        for (RacingCar raceWinner : raceWinners.getRaceWinners()) {
            stringBuilder.append(raceWinner.getName());
            stringBuilder.append(", ");
        }
        System.out.println( stringBuilder.substring(0, stringBuilder.length() - 2) );
    }
}
