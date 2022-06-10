package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.name.Names;

public class InputView {
    public static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    public static final String TRY_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";

    private InputView() {
    }

    public static Names askNameOfCars() {
        System.out.println(CAR_NAME_QUESTION);
        String input = Console.readLine();
        try {
            return new Names(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askNameOfCars();
        }
    }

    public static int getNumber() {
        System.out.println(TRY_COUNT_QUESTION);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            return getNumber();
        }
    }
}
