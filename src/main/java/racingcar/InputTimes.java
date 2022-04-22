package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Times;

public class InputTimes implements Input<Times> {
    private static final String INPUT_TIMES_MESSAGE = "시도할 회수는 몇회인가요?";

    @Override
    public Times input() {
        System.out.println(INPUT_TIMES_MESSAGE);
        Times times;
        do {
            times = make();
        } while (times == null);

        return times;
    }

    @Override
    public Times make() {
        try {
            return new Times(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
