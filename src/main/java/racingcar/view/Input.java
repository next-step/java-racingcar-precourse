package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import utils.ValidationUtils;

public class Input {

    public static final String MESSAGE_INPUT_CARNAMES = "경주할 자동차이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)";
    public static final String MESSAGE_INPUT_COUNTER = "시도할 회수는 몇회인가요?";

    public static String inputCarNames() {
        System.out.println(MESSAGE_INPUT_CARNAMES);
        return Console.readLine();
    }
    public static Integer inputCounter() {
        System.out.println(MESSAGE_INPUT_COUNTER);
        String readLine = Console.readLine();
        ValidationUtils.validNumberType(readLine);
        return Integer.parseInt(readLine);
    }
}
