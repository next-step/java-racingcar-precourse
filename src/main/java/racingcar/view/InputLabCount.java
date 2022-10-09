package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.entity.Lab;

public class InputLabCount {
    private static final String INPUT_LAP_COUNT_MSG = "시도할 회수는 몇회인가요?";

    public Lab getLab() {
        Lab labCount = null;
        try {
            System.out.println(INPUT_LAP_COUNT_MSG);
            labCount = new Lab(Console.readLine());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return labCount;
    }
}
