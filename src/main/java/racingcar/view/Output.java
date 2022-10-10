package racingcar.view;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.CarPosition;
import racingcar.model.car.Cars;
import racingcar.model.race.Winners;
import racingcar.model.value.ErrorMsg;
import racingcar.model.value.RaceMsg;

/**
 * 출력 처리 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class Output {

    public static void requestCarListInput() {
        System.out.println(RaceMsg.REQUEST_CAR_LIST_INPUT);
    }

    public static void requestRaceTrialInput() {
        System.out.println(RaceMsg.REQUEST_RACE_TRIAL_INPUT);
    }

    public static void printErrorMsg(String e) {
        System.out.println(ErrorMsg.BASE + e);
    }

    public static void printRoundResult(Cars cars) {
        System.out.println("\n");
        cars.printCarsPositions();
    }

    public static void printRaceStart() {
        System.out.println("\n");
        System.out.println(RaceMsg.RACE_RESULT_INTRODUCE);
    }

    public static void printRaceFinalWinner(Winners winners) {
        System.out.println("\n");
        StringBuilder builder = new StringBuilder();
        builder.append(RaceMsg.FINAL_WINNER);
        builder.append(winners.printWinner());
        String winnerText = builder.toString();
        System.out.println(winnerText);
    }

    public static void printCarPositionByCar(String carPositionWithName) {
        System.out.println(carPositionWithName);
    }
}
