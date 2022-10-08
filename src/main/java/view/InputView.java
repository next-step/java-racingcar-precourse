package view;

import camp.nextstep.edu.missionutils.Console;
import domain.CarNames;
import domain.Laps;

public class InputView {

    public static final String MESSAGE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    public static final String MESSAGE_INPUT_LAPS = "시도할 회수는 몇회인가요?";

    public static CarNames getCarNames() {
        System.out.println(MESSAGE_INPUT_CAR_NAMES);
        try {
            return new CarNames(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNames();
        }
    }

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
