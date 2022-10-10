package racingcar.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

public class RacingTrialsInputView {
    private static final String QUESTION = "시도할 횟수는 몇 회인가요?";

    public static RacingTrialsInput inputRacingTrials() {
        printQuestion();
        final int trials = readInt();
        return new RacingTrialsInput(trials);
    }

    private static int readInt() {
        String input = readLine();
        try {
            return parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요! 입력값: '" + input + "'");
        }
    }

    private static void printQuestion() {
        System.out.println(QUESTION);
    }
}
