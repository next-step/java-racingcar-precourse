package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.view.InputMessageView.printInputCarNamesMessage;
import static racingcar.view.InputMessageView.printInputRacingRoundsMessage;

public class GameInputReader {

    public static List<String> readRacingCarNames() {
        printInputCarNamesMessage();
        return splitInputByComma(readLine());
    }

    public static String readRacingRounds() {
        printInputRacingRoundsMessage();
        return readLine().trim();
    }

    private static List<String> splitInputByComma(String input) {
        List<String> splitStrings = new ArrayList<>();
        for (String str : input.split(",")) {
            splitStrings.add(str.trim());
        }
        return splitStrings;
    }
}
