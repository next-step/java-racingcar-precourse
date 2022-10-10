package racingcar.view;

import static racingcar.util.Constans.CAR_ROUND_RESULT_DELIMITER;
import static racingcar.util.Messages.INPUT_CAR_NAMES;
import static racingcar.util.Messages.INPUT_RACING_ROUND;
import static racingcar.util.Messages.OUTPUT_RACING_WINNER;

import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import camp.nextstep.edu.missionutils.Console;

public class RacingView {
    public void printRacingResult(RacingCars racingCars) {
        for (Car car : racingCars.getCarList()) {
            System.out.printf("%s:%s%n", car.getName(), getPositionDottedLine(car.getPosition()));
        }
        System.out.println();
    }

    private String getPositionDottedLine(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(CAR_ROUND_RESULT_DELIMITER);
        }
        return stringBuilder.toString();
    }

    public String printInputCarName() {
        System.out.println(INPUT_CAR_NAMES);
        return Console.readLine();
    }

    public String printInputRound() {
        System.out.println(INPUT_RACING_ROUND);
        return Console.readLine();
    }

    public void printOutWinnerCars(ArrayList<String> winnerCars) {
        System.out.println(OUTPUT_RACING_WINNER+String.join(", ",winnerCars));
    }
}
