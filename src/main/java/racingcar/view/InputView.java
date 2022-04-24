package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.wrapper.Racers;
import racingcar.domain.wrapper.RoundCount;
import racingcar.exception.RacingException;

public class InputView {
    private static final String INPUT_RACERS = "경주 할 자동차 이름(이름은 쉼표(,) 기준 으로 구분)";
    private static final String INPUT_PLAY_COUNT = "시도할 횟수";

    public static Racers printStartMessage() {
        try {
            System.out.println(INPUT_RACERS);
            return new Racers(input());
        } catch (RacingException e) {
            return printStartMessage();
        }
    }

    public static RoundCount printPlayCountMessage() {
        try {
            System.out.println(INPUT_PLAY_COUNT);
            return new RoundCount(input());
        } catch (RacingException e) {
            return printPlayCountMessage();
        }
    }

    private static String input() {
        return Console.readLine().trim();
    }
}
