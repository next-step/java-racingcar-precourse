package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String CAR_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)";
    public static final String CAR_INPUT_TIME = "경주 할 횟수를 입력하세요.";

    static public InputView of() {
        return new InputView();
    }

    /**
     * 경주할 자동차 이름
     *
     * @return 사용자가 입력한 자동차 이름들
     */
    public String inputCars() {
        System.out.println(CAR_INPUT_GUIDE);
        return Console.readLine();
    }

    /**
     * 경주 횟수
     *
     * @return 사용자가 입력한 경주 횟수
     */
    public String inputTimes() {
        System.out.println(CAR_INPUT_TIME);
        return Console.readLine();
    }
}
