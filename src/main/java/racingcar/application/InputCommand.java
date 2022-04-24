package racingcar.application;

import camp.nextstep.edu.missionutils.Console;

public class InputCommand {

    private static final String ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_TRY_NUMBER = "시도할 회수는 몇회인가요?";

    public String askCarNames() {
        System.out.println(ASK_CAR_NAME);
        return Console.readLine();
    }

    public Integer askTryNumber() {
        System.out.println(ASK_TRY_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

}
