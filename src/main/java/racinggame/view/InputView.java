package racinggame.view;

import nextstep.utils.Console;
import racinggame.RacingGame;
import racinggame.utils.ValidationUtils;

public class InputView {

    private static final String ERROR_MSG = "[ERROR]";

    public static RacingGame inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = Console.readLine();
        while (!ValidationUtils.enablePlayGame(str)) {
            printErrorMsg();
            str = Console.readLine();
        }
        return new RacingGame(str);
    }

    public static String inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String str = Console.readLine();
        while (!ValidationUtils.isNumberic(str)) {
            printErrorMsg();
            str = Console.readLine();
        }
        return str;
    }

    public static void printErrorMsg() {
        System.out.println(ERROR_MSG);
    }
}
