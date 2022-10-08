package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Laps;

public class InputView {

    public static final String MESSAGE_INPUT_LAPS = "시도할 회수는 몇회인가요?";

    public static Laps getLaps() {
        System.out.println(MESSAGE_INPUT_LAPS);
        try {
            return new Laps(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLaps();
        }
    }
}
