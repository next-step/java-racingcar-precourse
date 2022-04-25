package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.core.Constant.*;

public class GameView {

    public List<String> inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        return Arrays.asList(Console.readLine().split(SEPARATOR));
    }

    public String inputRacingRound() {
        System.out.println(TRY_COUNT);
        return Console.readLine();
    }

    public void displayError(String message) {
        System.out.println(message);
    }

    public void displayResults(String proceedRace) {
        System.out.print(proceedRace);
    }

    public void finalResult(String names) {
        System.out.printf(FINAL_WINNER, names);
    }
}
